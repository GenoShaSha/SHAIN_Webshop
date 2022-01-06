package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import web_application.model.Order;
import web_application.model.Product;

public interface IOrder extends JpaRepository<Order,Long> {
    Order getOrderByUsername(String username);
    Order getOrderByOrderReference(String reference);
}

