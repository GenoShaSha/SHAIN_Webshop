package web_application.interfaces;

import web_application.model.Member;
import web_application.model.Product;
import web_application.model.ProductTransferData;

import java.util.List;

public interface IProductService {
    void AddProduct(Product product);
    List<Product> GetAllProduct();
    void RemoveProduct(Product product);
    void UpdateProduct(Product product, int artNumber);
    List<ProductTransferData> getProductsByCategory_GenderAnAndCategory_Name(String gender, String name);
    Product getProductsByArticleNumber(int newArtNumb);
}
