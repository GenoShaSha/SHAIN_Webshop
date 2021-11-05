package categoryTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import web_application.model.Category;
import web_application.model.Member;
import web_application.repository.FakeData;

@ContextConfiguration
public class cathegoryTest {

    @Test
    public void AddAndRemoveCaregoryTest()
    {
        FakeData fake = new FakeData();

        fake.addCategory(new Category("BKS","Pants"));

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

        fake.addCategory(new Category("BKS","Pants"));

        Category test = fake.getCategory("BKS");

        Assertions.assertEquals(test.getName(),"Pants");

        fake.updateCategory("BKS",new Category("BSK","Pants"));

        Category test2 = fake.getCategory("BSK");

        Assertions.assertEquals("Pants",test2.getName());

    }

}
