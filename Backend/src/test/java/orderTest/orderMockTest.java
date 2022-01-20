package orderTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web_application.dummyData.FakeMemberRepo;
import web_application.dummyData.FakeOrderRepo;
import web_application.dummyData.FakeProductRepo;
import web_application.model.Category;
import web_application.model.Member;
import web_application.model.Order;
import web_application.model.Product;
import web_application.security.UserCreateRequest;
import web_application.service.MemberService;
import web_application.service.OrderService;
import web_application.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration
public class orderMockTest {
    @Test
    public void AddOrderTest()
    {
        FakeProductRepo fakerepo = new FakeProductRepo();
        ProductService service = new ProductService(fakerepo);
        FakeOrderRepo fakeOrderRepo = new FakeOrderRepo();
        OrderService orderService = new OrderService(fakeOrderRepo,service);

        List<Product> products = new ArrayList<>();

        Category shirts = new Category("SRT","Shirts","s");
        Product product1 = new Product(5,"MOLAS",shirts,"L",10,15.00,"zzzz",1);
        products.add(product1);
        service.AddProduct(product1);

        Category jeans = new Category("JNS","jeans","s");
        Product product2 = new Product(10,"BLABLA",jeans,"M",2,30.00,"blabla",3);
        products.add(product2);
        service.AddProduct(product2);



        orderService.AddOrder(new Order(45, "STANISLAV",products,"s"));

        orderService.AddOrder(new Order(45, "STANISLAV",products,"s"));

        List<Order> test = orderService.getOrdersByUsername("STANISLAV");


        Assertions.assertEquals(test.size(),2);

        Product product3 = new Product(10,"BLABLA",jeans,"M",10,30.00,"blabla",11);
        List<Product> products2 = new ArrayList<>();
        products2.add(product3);
        service.AddProduct(product3);

        orderService.AddOrder(new Order(45, "STANISLAV",products2,"s"));

        List<Order> test2 = orderService.getOrdersByUsername("STANISLAV");


        Assertions.assertEquals(test2.size(),2);
    }

}
