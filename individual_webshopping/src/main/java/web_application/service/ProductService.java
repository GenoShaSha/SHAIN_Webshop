package web_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_application.interfaces.IProductRepo;
import web_application.interfaces.IProductService;
import web_application.model.Product;

import java.util.List;

@Service
public class ProductService implements IProductService {
    IProductRepo repo;

    @Autowired
    public ProductService(IProductRepo repo){
        this.repo = repo;
    }
    @Override
    public void AddProduct(Product product) {
        repo.AddProduct(product);
    }

    @Override
    public List<Product> GetAllProduct() {
        return repo.GetAllProduct();
    }

    @Override
    public void RemoveProduct(Product product) {
        repo.RemoveProduct(product);
    }
}
