package categoryTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import web_application.model.Category;
import web_application.dummyData.FakeData;

@SpringBootConfiguration
@SpringBootTest
public class CategoryTest {

    @Test
    public void AddAndRemoveCategoryTest()
    {
        FakeData fake = new FakeData();

        fake.addCategory(new Category("BKS","Pants","s"));

        Category test = fake.getCategory("BKS");

        Assertions.assertEquals(test.getName(),"Pants");

        fake.deleteCategory("BKS");

        Category test2 = fake.getCategory("BKS");

        Assertions.assertEquals(test2,null);

    }

    @Test
    public void UpdateCategoryTest()
    {
        FakeData fake = new FakeData();

        fake.addCategory(new Category("BKS","Pants","s"));

        Category test = fake.getCategory("BKS");

        Assertions.assertEquals(test.getName(),"Pants");

        fake.updateCategory("BKS",new Category("BSK","Pants","s"));

        Category test2 = fake.getCategory("BSK");

        Assertions.assertEquals("Pants",test2.getName());

    }

}
