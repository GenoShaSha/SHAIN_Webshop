package web_application.dummyData;

import web_application.interfaces.IOrderRepo;
import web_application.model.Member;
import web_application.model.Order;

import java.util.ArrayList;
import java.util.List;

public class FakeOrderRepo implements IOrderRepo {
    ArrayList<Order> FakeOrders;

    public FakeOrderRepo() {
        FakeOrders = new ArrayList<>();
    }

    @Override
    public void AddOrder(Order order) {
        FakeOrders.add(order);
    }

    @Override
    public List<Order> getOrdersByUsername(String username) {
        List<Order> orders = new ArrayList<>();
        for(Order order : FakeOrders){
            if(order.getUsername().equals(username)){
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public Order getOrderByOrderReference(String reference) {
        for(Order order : FakeOrders){
            if(order.getOrderReference().equals(reference)){
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> GetAllOrder() {
        return FakeOrders;
    }
}
