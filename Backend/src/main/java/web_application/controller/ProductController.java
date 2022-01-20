package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web_application.interfaces.IProductService;
import web_application.model.Member;
import web_application.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    IProductService logic;

    @GetMapping //Get All Products
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(logic.GetAllProduct());
    }

    @GetMapping("/{artNumb}")
    public ResponseEntity<Product> getProductByArtNumb(@PathVariable int artNumb){
        Product p = logic.getProductsByArticleNumber(artNumb);
        return ResponseEntity.ok().body(p);
    }


    @GetMapping("/{CatGender}/{CatName}")
    public ResponseEntity<List<Product>> getProductPath(@PathVariable(value = "CatGender") String gender,@PathVariable(value = "CatName") String name) {
        List<Product> temp = logic.getProductsByCategory_GenderAnAndCategory_Name(gender,name);
        return ResponseEntity.ok().body(temp);
    }
    @PostMapping()
    public ResponseEntity createProduct(@RequestBody Product product) {

        try{
            if (logic.getProductsByArticleNumber(product.getArticleNumber())!= null){
                String entity =  "This product already exists.";
                return new ResponseEntity(entity, HttpStatus.CONFLICT);
            } else {
                product.setCount(1);
                logic.AddProduct(product);
                return new ResponseEntity(HttpStatus.CREATED);
            }
        }
        catch (Exception e){
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{artNumber}")
    public ResponseEntity<String> updateProdQty(@PathVariable int artNumber, @RequestBody Product product){
        try{
            logic.UpdateProduct(product,artNumber);
            return ResponseEntity.ok().body("updated");
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

}
