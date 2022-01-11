package web_application.service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web_application.interfaces.IOrderRepo;
import web_application.interfaces.IOrderService;
import web_application.interfaces.IProductRepo;
import web_application.interfaces.IProductService;
import web_application.model.Order;
import web_application.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    IOrderRepo repo;
    private final IProductService prodLogic;

    @Autowired
    public OrderService(IOrderRepo repo,IProductService prod){
        this.repo = repo;
        prodLogic = prod;
    }

    @Override
    public boolean AddOrder(Order order) {

        List<Product> listOfProduct = order.getProducts();
        List<Product> unavailableProd = new ArrayList<>();



        for (Product p : listOfProduct) {
            if (p.getCount() > p.getQty()) {
                unavailableProd.add(p);
            } else {
                int newQuantity = prodLogic.getProductsByArticleNumber(p.getArticleNumber()).getQty() - p.getCount();
                p.setCount(1);
                p.setQty(newQuantity);
                prodLogic.AddProduct(p);
            }
        }
        listOfProduct.removeAll(unavailableProd);
        if(listOfProduct.isEmpty()){
            return false;
        }
        else {
            String random = RandomString.make(5);
            Order newOrder = new Order(order.getTotalPrice(),order.getUsername(),listOfProduct,random);
            repo.AddOrder(newOrder);
            return true;
        }
    }

    @Override
    public List<Order> getOrdersByUsername(String username) {
        return repo.getOrdersByUsername(username);
    }

    @Override
    public Order getOrderByOrderReference(String reference) {
        return repo.getOrderByOrderReference(reference);
    }

    @Override
    public List<Order> GetAllOrder() {
        return repo.GetAllOrder();
    }
}
