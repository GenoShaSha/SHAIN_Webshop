package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web_application.dataConnection.ICategory;
import web_application.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategory repo;



    @GetMapping("/welcome")
    @ResponseBody
    public String SayWelcome()
    {
        repo.save(new Category("S","S","S"));
        return null;
    }

    @GetMapping //Get All Category
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = null;
        categories = repo.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/woman")
    public ResponseEntity<List<Category>> getCatWoman() {
        List<Category> categories = repo.getCategoriesByGender("W");
        if(categories != null) {
            return ResponseEntity.ok().body(categories);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/man")
    public ResponseEntity<List<Category>> getCatMan() {
        List<Category> categories = repo.getCategoriesByGender("M");
        if(categories != null) {
            return ResponseEntity.ok().body(categories);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{catCode}")
    public ResponseEntity<Category> getCatPath(@PathVariable(value = "catCode") String catCode) {
        if(catCode != null) {
            return ResponseEntity.ok().body(new Category("s","s","s"));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    //POST at http://localhost:XXXX/category/
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        System.out.println(category.getCatCode());
        System.out.println(category.getName());

        repo.save(category);
            return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/category/JNS
    public ResponseEntity deleteCategory(@PathVariable String code)
    {
        return ResponseEntity.ok().build();
    }

}
