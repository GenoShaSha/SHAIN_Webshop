package web_application.interfaces;

import web_application.model.Order;
import web_application.model.Product;

import java.util.List;

public interface IOrderRepo {
    void AddOrder(Order order);
    Order getOrderByUsername(String username);
    Order getOrderByOrderReference(String reference);
    List<Order> GetAllOrder();
}
