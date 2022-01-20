package web_application.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ProductAmount")
@NoArgsConstructor
public class ProductOrderAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    Product product;
    private int amount;

    public ProductOrderAmount(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
