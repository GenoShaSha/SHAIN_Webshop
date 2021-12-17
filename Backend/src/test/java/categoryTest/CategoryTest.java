package categoryTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import web_application.dummyData.FakeCategoryRepo;
import web_application.model.Category;
import web_application.service.CategoryService;

import java.util.List;

@SpringBootConfiguration
@SpringBootTest
public class CategoryTest {

    @Test
    public void AddCategoryTest()
    {
        FakeCategoryRepo fakerepo = new FakeCategoryRepo();
        CategoryService service = new CategoryService(fakerepo);

        service.AddCategory(new Category("BKS","Pants","s"));

        Category test = service.GetAllCategory().get(0);

        Assertions.assertEquals(test.getName(),"Pants");

    }


    @Test
    public void GetCategoriesByGender()
    {
        FakeCategoryRepo fakerepo = new FakeCategoryRepo();
        CategoryService service = new CategoryService(fakerepo);

        service.AddCategory(new Category("BKS","Pants","F"));
        service.AddCategory(new Category("BKS","Pants","M"));

        List<Category> test = service.getCategoriesByGender("M");

        Assertions.assertEquals(test.size(),1);

    }

}
