package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import web_application.model.Order;
import web_application.model.Product;

import java.util.List;

public interface IOrder extends JpaRepository<Order,Long> {
    List<Order> getOrdersByUsername(String username);
    Order getOrderByOrderReference(String reference);
}

