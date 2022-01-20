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
import web_application.model.ProductOrderAmount;

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
        List<Product> listOfProductsToOrder = new ArrayList<>();
        List<Product> unavailableProd = new ArrayList<>();
        List<ProductOrderAmount> listOfProductAmount = new ArrayList<>();

        double price = order.getTotalPrice();


        for (Product p : listOfProduct) {
            Product item = prodLogic.getProductsByArticleNumber(p.getArticleNumber());
            if (item.getQty() < p.getCount() && item.getQty() >= 1 ){
                p.setCount(p.getQty());
            }
            if (item.getQty() < 1) {
                unavailableProd.add(p);
            }
            if (item.getQty() >= p.getCount() && item.getQty() >= 1 ) {
                int newQuantity = item.getQty() - p.getCount();
                listOfProductsToOrder.add(p);
                p.setQty(newQuantity);
                prodLogic.AddProduct(p);
            }
        }
        listOfProduct.removeAll(unavailableProd);
        if(listOfProduct.isEmpty()){
            return false;
        }
        else {
            for (Product p: listOfProductsToOrder) {
                listOfProductAmount.add(new ProductOrderAmount(p,p.getCount()));
            }
            String random = RandomString.make(5);
            Order newOrder = new Order(order.getTotalPrice(),order.getUsername(),random,listOfProductAmount,order.getAddress());

            repo.AddOrder(newOrder);

            for (Product p: listOfProductsToOrder) {
                p.setCount(1);
                prodLogic.AddProduct(p);
            }
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
