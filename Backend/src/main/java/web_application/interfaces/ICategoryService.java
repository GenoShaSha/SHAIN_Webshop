package web_application.interfaces;

import web_application.model.Category;

import java.util.List;

public interface ICategoryService {
    void AddCategory(Category category);
    List<Category> GetAllCategory();
    List<Category> getCategoriesByGender(String gender);
}
