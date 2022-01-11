package web_application.interfaces;

import web_application.model.Order;

import java.util.List;

public interface IOrderService {
    boolean AddOrder(Order order);
    List<Order> getOrdersByUsername(String username);
    Order getOrderByOrderReference(String reference);
    List<Order> GetAllOrder();
}
