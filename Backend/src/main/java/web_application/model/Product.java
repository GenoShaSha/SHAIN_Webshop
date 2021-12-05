package web_application.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int articleNumber;
    private String productName;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categories_id")
    private Category category;
    private String size;
    private int qty;
    private double price;



    public Product(){}

    public Product(int articleNumber, String productName, Category category, String size, int qty, double price){
        this.articleNumber = articleNumber;
        this.productName = productName;
        this.category = category;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    public int getArticleNumber(){
        return articleNumber;
    }
    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Product:" +
                "Article Number=" + articleNumber +
                ", Product Name=" + productName +
                ", Categories=" + category +
                ", Size=" + size +
                ", Quantity=" + qty +
                ", Price=" + price;
    }
}
