package productTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import web_application.model.Category;
import web_application.model.Member;
import web_application.model.Product;
import web_application.repository.FakeData;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration
public class productMockTest {


    @Test
    public void AddAndRemoveProductTest()
    {
        FakeData fake = new FakeData();

        Category shirts = new Category("SRT","Shirts");
        fake.addProduct(new Product(5,"MOLAS",shirts,"L",10));

        Product test = fake.getProduct(5);
        Product test3 = fake.getProduct("MOLAS");


        Assertions.assertEquals(test.getProductName(),"MOLAS");
        Assertions.assertEquals(test3.getArticleNumber(),5);


        fake.deleteProduct(5);

        Product test2 = fake.getProduct(5);


        Assertions.assertEquals(test2,null);

    }



    @Test
    public void UpdateProductTest()
    {
        FakeData fake = new FakeData();

        Category shirts = new Category("SRT","Shirts");
        fake.addProduct(new Product(5,"MOLAS",shirts,"L",10));

        Product test = fake.getProduct(5);

        Assertions.assertEquals(test.getProductName(),"MOLAS");

        fake.updateProduct("MOLAS",new Product(5,"MONAS",shirts,"L",10));

        Product test2 = fake.getProduct(5);

        Assertions.assertEquals("MONAS",test2.getProductName());

    }


}
