package web_application.interfaces;

import web_application.model.Category;
import web_application.model.Product;

import java.util.List;

public interface ICategoryRepo {
    void AddCategory(Category category);
    List<Category> GetAllCategory();
    List<Category> getCategoriesByGender(String gender);
}
