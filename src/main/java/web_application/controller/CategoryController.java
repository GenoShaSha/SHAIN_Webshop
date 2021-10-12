package web_application.controller;

import web_application.model.Category;
import web_application.repository.FakeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")


public class CategoryController {
    private static final FakeData fakeData = new FakeData();

    @GetMapping("/welcome")
    @ResponseBody
    public String SayWelcome()
    {

        return "Welcome to our website!";
    }
    @GetMapping //Get All Category
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = null;
        categories = fakeData.getCategory();
        if(categories != null) {
            return ResponseEntity.ok().body(categories);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{catCode}") //GET at http://localhost:XXXX/catCode/JNS
    public ResponseEntity<Category> getCatPath(@PathVariable(value = "catCode") String catCode) {
        Category categories = fakeData.getCategory(catCode);
        if(categories != null) {
            return ResponseEntity.ok().body(categories);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    //POST at http://localhost:XXXX/category/
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        if (!fakeData.addCategory(category)){
            String entity =  "This category with this CODE : " + category.getCatCode() + " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "category" + "/" + category.getCatCode();
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }

    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/category/JNS
    public ResponseEntity deleteCategory(@PathVariable String code)
    {
        fakeData.deleteCategory(code);
        return ResponseEntity.ok().build();
    }

}