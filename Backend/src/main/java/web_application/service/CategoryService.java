package web_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_application.dataConnection.IProduct;
import web_application.interfaces.ICategoryRepo;
import web_application.interfaces.ICategoryService;
import web_application.model.Category;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepo repo;

    public CategoryService(ICategoryRepo repo){
        this.repo= repo;
    }

    @Override
    public void AddCategory(Category category) {
        repo.AddCategory(category);
    }

    @Override
    public List<Category> GetAllCategory() {
        return repo.GetAllCategory();
    }

    @Override
    public List<Category> getCategoriesByGender(String gender) {
        return repo.getCategoriesByGender(gender);
    }
}
