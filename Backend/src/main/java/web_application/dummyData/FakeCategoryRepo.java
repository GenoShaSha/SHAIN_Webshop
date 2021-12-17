package web_application.dummyData;

import web_application.interfaces.ICategoryRepo;
import web_application.model.Category;

import java.util.ArrayList;
import java.util.List;

public class FakeCategoryRepo implements ICategoryRepo {

    ArrayList<Category> FakeCategories;

    public FakeCategoryRepo() {
        FakeCategories = new ArrayList<>();
    }

    @Override
    public void AddCategory(Category category) {
        FakeCategories.add(category);
    }

    @Override
    public List<Category> GetAllCategory() {
        return FakeCategories;
    }

    @Override
    public List<Category> getCategoriesByGender(String gender) {
        ArrayList<Category> temp = new ArrayList<>();
        for (Category category : FakeCategories){
            if (category.getGender().equals(gender)){
                temp.add(category);
            }
        }
        return  temp;
    }
}
