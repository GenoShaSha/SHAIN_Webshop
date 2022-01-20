package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web_application.dataConnection.ICategory;
import web_application.interfaces.ICategoryService;
import web_application.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_application.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService logic;

    @GetMapping //Get All Category
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = null;
        categories = logic.GetAllCategory();
        return ResponseEntity.ok().body(categories);
    }
    @GetMapping("/woman")
    public ResponseEntity<List<Category>> getCatWoman() {
        List<Category> categories = logic.getCategoriesByGender("W");
        if(categories != null) {
            return ResponseEntity.ok().body(categories);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/man")
    public ResponseEntity<List<Category>> getCatMan() {
        List<Category> categories = logic.getCategoriesByGender("M");
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
        try{
            logic.AddCategory(category);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
}
