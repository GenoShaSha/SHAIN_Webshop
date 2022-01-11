package productTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import web_application.dummyData.FakeCategoryRepo;
import web_application.dummyData.FakeProductRepo;
import web_application.model.Category;
import web_application.model.Product;
import web_application.service.CategoryService;
import web_application.service.ProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootConfiguration
public class productMockTest {


    @Test
    public void AddAndRemoveProductTest()
    {
        FakeProductRepo fakerepo = new FakeProductRepo();
        ProductService service = new ProductService(fakerepo);

        Category shirts = new Category("SRT","Shirts","s");
        service.AddProduct(new Product(5,"MOLAS",shirts,"L",10,15.00));

        Product test = service.getProductsByArticleNumber(5);

        Assertions.assertEquals(test.getProductName(),"MOLAS");

        service.RemoveProduct(test);

        Product test2 = service.getProductsByArticleNumber(5);


        Assertions.assertEquals(test2,null);

    }




}
