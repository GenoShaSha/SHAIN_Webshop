package web_application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web_application.dataConnection.ICategory;
import web_application.dataConnection.IProduct;
import web_application.interfaces.ICategoryRepo;
import web_application.model.Category;

import java.util.List;

@Repository
public class CategoryRepo implements ICategoryRepo {
    @Autowired
    ICategory repo;

    public CategoryRepo(){

    }
    @Override
    public void AddCategory(Category category) {
        repo.save(category);
    }

    @Override
    public List<Category> GetAllCategory() {
        return repo.findAll();
    }

    @Override
    public List<Category> getCategoriesByGender(String gender) {
        return repo.getCategoriesByGender(gender);
    }
}
