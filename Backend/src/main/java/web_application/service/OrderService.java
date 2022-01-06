package web_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_application.interfaces.IOrderRepo;
import web_application.interfaces.IOrderService;
import web_application.interfaces.IProductRepo;
import web_application.model.Order;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    IOrderRepo repo;

    @Autowired
    public OrderService(IOrderRepo repo){
        this.repo = repo;
    }

    @Override
    public void AddOrder(Order order) {
        repo.AddOrder(order);
    }

    @Override
    public Order getOrderByUsername(String username) {
        return repo.getOrderByUsername(username);
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
