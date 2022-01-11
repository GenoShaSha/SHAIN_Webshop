package web_application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web_application.dataConnection.IOrder;
import web_application.interfaces.IOrderRepo;
import web_application.model.Order;

import java.util.List;

@Repository
public class OrderRepo implements IOrderRepo {

    @Autowired
    IOrder repo;

    @Override
    public void AddOrder(Order order) {
        repo.save(order);
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
        return repo.findAll();
    }
}
