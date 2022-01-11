package web_application.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int totalPrice;
    private String username;
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String orderReference;
    @ManyToMany
    @JoinColumn(name = "product_id", nullable = false)
    private List<Product> products;

    public Order(){

    }

    public Order(int totalPrice, String username, List<Product> products) {
        this.totalPrice = totalPrice;
        this.username = username;
        this.products = products;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public Order(int totalPrice, String username, List<Product> products, String orderReference){
        this.totalPrice = totalPrice;
        this.username = username;
        this.products = products;
        this.orderReference = orderReference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
