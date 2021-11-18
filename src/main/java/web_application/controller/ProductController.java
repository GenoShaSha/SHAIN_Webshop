package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web_application.dataConnection.IProduct;
import web_application.model.Category;
import web_application.model.Product;
import web_application.repository.FakeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")

public class ProductController {
    private static final FakeData fakeData = new FakeData();

    @Autowired
    IProduct repo;

    @GetMapping("/welcome")
    @ResponseBody
    public String SayWelcome()
    {
        repo.save(new Product(5,"MOLAS",new Category("SRT","Shirts"),"L",10,15.00));
        return null;
    }
    @GetMapping //Get All Products
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(value = "category") Optional<String> category) {
        List<Product> products = null;
        if(category.isPresent()) {
            Category c = fakeData.getCategory(category.get());
            products = fakeData.getProduct(c);
        }
        else
        {
            products = fakeData.getProduct();
        }
        if(products != null) {
            return ResponseEntity.ok().body(products);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{artNumb}") //GET at http://localhost:XXXX/artNumb/10000
    public ResponseEntity<Product> getProductPath(@PathVariable(value = "artNumb") int artNumb) {
        Product products = fakeData.getProduct(artNumb);
        if(products != null) {
            return ResponseEntity.ok().body(products);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    //POST at http://localhost:XXXX/product/
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if (!fakeData.addProduct(product)){
            String entity =  "This product with the Art. Number : " + product.getArticleNumber() + " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "member" + "/" + product.getArticleNumber();
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
