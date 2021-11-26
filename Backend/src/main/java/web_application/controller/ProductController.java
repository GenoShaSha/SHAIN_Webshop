package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web_application.dataConnection.IProduct;
import web_application.interfaces.IProductService;
import web_application.model.Category;
import web_application.model.Member;
import web_application.model.Product;
import web_application.dummyData.FakeData;
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
    IProductService logic;

    @   GetMapping("/welcome")
    @ResponseBody
    public String SayWelcome()
    {
        repo.save(new Product(5,"MOLAS",new Category("SRT","Shirts","s"),"L",10,15.00));
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

    @GetMapping("/{CatGender}/{CatName}")
    public ResponseEntity<List<Product>> getProductPath(@PathVariable(value = "CatGender") String gender,@PathVariable(value = "CatName") String name) {
//       get all products where category.gender == gender && product.gategory.name == name
        List<Product> temp = repo.getProductsByCategory_GenderAnAndCategory_Name(gender,name);
        return ResponseEntity.ok().body(temp);
    }


    @PostMapping()
    //POST at http://localhost:XXXX/member/
    public ResponseEntity<Member> createProduct(@RequestBody Product product) {
        if (repo.getProductsByArticleNumber(product.getArticleNumber())!= null){
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
