package WebApplication.model;

public class Product {
    private int productID;
    private int articleNumber;
    private String productName;
    private Category category;
    private String size;
    private int qty;

    public Product(int articleNumber, String productName, Category category, String size, int qty){
//        this.productID = productID;
        this.articleNumber = articleNumber;
        this.productName = productName;
        this.category = category;
        this.size = size;
        this.qty = qty;
    }

    //    public int getProductID(){
//        return productID;
//    }
//    public void setProductID(int productID){
//        this.productID = productID;
//    }
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

//    @Override
//    public boolean equals(Object obj){
//        if(this == obj){
//            return  true;
//        }
//        if(obj == null || getClass() != obj.getClass()){
//            return false;
//        }
//        Products products = (Products) obj;
//        return articleNumber == products.articleNumber
//        && (productName.equals(products.productName)
//                && categories.equals(products.categories)
//                && size.equals(products.size));
//    }

//    //@Override
//    public int hasCode(){
//        return Objects.hash(articleNumber);
//    }

    @Override
    public String toString(){
        return "Product:" +
                "Article Number=" + articleNumber +
                ", Product Name=" + productName +
                ", Categories=" + category +
                ", Size=" + size +
                ", Quantity=" + qty;
    }
}
