package web_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_application.interfaces.IProductRepo;
import web_application.interfaces.IProductService;
import web_application.model.Member;
import web_application.model.Product;

import java.util.ArrayList;
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

    @Override
    public void UpdateProduct(Product product, int artNumber) {
        Product p = repo.getProductsByArticleNumber(artNumber);
        p.setQty(product.getQty());
        repo.AddProduct(p);
    }

    @Override
    public List<Product> getProductsByCategory_GenderAnAndCategory_Name(String gender, String name) {
        ArrayList<Product> newItems = new ArrayList<>();
        for (Product p : repo.getProductsByCategory_GenderAnAndCategory_Name(gender,name)) {
            if (p.getQty() > 0){
                p.setQty(-1);
                newItems.add(p);
            }
        }
        return newItems;
    }

    @Override
    public Product getProductsByArticleNumber(int newArtNumb) {
        return repo.getProductsByArticleNumber(newArtNumb);
    }
}
