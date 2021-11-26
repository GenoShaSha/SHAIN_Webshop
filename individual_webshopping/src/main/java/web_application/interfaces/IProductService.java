package web_application.interfaces;

import web_application.model.Product;

import java.util.List;

public interface IProductService {
    void AddProduct(Product product);
    List<Product> GetAllProduct();
    void RemoveProduct(Product product);
}
