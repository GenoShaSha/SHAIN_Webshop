package web_application.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int articleNumber;
    private String productName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categories_id")
    private Category category;
    private String size;
    private int qty;
    private double price;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "categories_id")
    private Long categoryId;

    public Product(){}


    public Product(int articleNumber, String productName, Long categoryId, String size, int qty, double price){
        this.articleNumber = articleNumber;
        this.productName = productName;
        this.categoryId = categoryId;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

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
    public Category getCategories(){
        return category;
    }
    public String getSize(){
        return size;
    }
    public int getQuantity(){
        return qty;
    }
    public void setQuantity(int qty){
        this.qty = qty;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString(){
        return "Product:" +
                "Article Number=" + articleNumber +
                ", Product Name=" + productName +
                ", Categories=" + category +
                ", Size=" + size +
                ", Quantity=" + qty +
                ", Price=" + price + this.categoryId;
    }
}