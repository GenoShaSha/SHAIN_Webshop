package web_application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web_application.dataConnection.IProduct;
import web_application.interfaces.IProductRepo;
import web_application.model.Product;
import web_application.model.ProductTransferData;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    @Autowired
    IProduct repo;

    public ProductRepo(){

    }

    @Override
    public void AddProduct(Product product) {
        repo.save(product);
    }

    @Override
    public List<Product> GetAllProduct() {
        return repo.findAll();
    }

    @Override
    public void RemoveProduct(Product product) {
        repo.delete(product);
    }

    @Override
    public List<ProductTransferData> getProductsByCategory_GenderAnAndCategory_Name(String gender, String name) {
        ArrayList<ProductTransferData> newItems = new ArrayList<>();
        for (Product p : repo.getProductsByCategory_GenderAndCategory_Name(gender,name)) {
            newItems.add(new ProductTransferData(p.getId(),p.getArticleNumber(),p.getProductName(),p.getCategory(),p.getSize(),p.getPrice(),p.getUrl(),p.getCount()));
        }
        return newItems;
    }
    @Override
    public Product getProductsByArticleNumber(int newArtNumb) {
        return repo.getProductsByArticleNumber(newArtNumb);
    }

}
