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

    @GetMapping("/{CatGender}/{CatName}")
    public ResponseEntity<List<Product>> getProductPath(@PathVariable(value = "CatGender") String gender,@PathVariable(value = "CatName") String name) {
//       get all products where category.gender == gender && product.gategory.name == name
        List<Product> temp = logic.getProductsByCategory_GenderAnAndCategory_Name(gender,name);
        return ResponseEntity.ok().body(temp);
    }


    @PostMapping()
    //POST at http://localhost:XXXX/member/
    public ResponseEntity<Member> createProduct(@RequestBody Product product) {

        if (logic.getProductsByArticleNumber(product.getArticleNumber())!= null){
            String entity =  "This product already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            logic.AddProduct(product);
            String url = "product" + "/" + product.getArticleNumber();
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }

//
//    @DeleteMapping("{ArtNumb}")
//    //DELETE at http://localhost:XXXX/product/10000
//    public ResponseEntity deleteProduct(@PathVariable int artnumb)
//    {
//        fakeData.deleteMember(artnumb);
//        return ResponseEntity.ok().build();
//    }


}
