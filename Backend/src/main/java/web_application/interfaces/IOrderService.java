package web_application.interfaces;

import web_application.model.Order;

import java.util.List;

public interface IOrderService {
    void AddOrder(Order order);
    Order getOrderByUsername(String username);
    Order getOrderByOrderReference(String reference);
    List<Order> GetAllOrder();
}
