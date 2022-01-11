package web_application.dummyData;

import web_application.interfaces.IProductRepo;
import web_application.model.Category;
import web_application.model.Member;
import web_application.model.Product;

import java.util.ArrayList;
import java.util.List;

public class FakeProductRepo implements IProductRepo {
    ArrayList<Product> FakeProducts;

    public FakeProductRepo(){
        FakeProducts = new ArrayList<>();
    }

    @Override
    public void AddProduct(Product product) {
        FakeProducts.add(product);
    }

    @Override
    public List<Product> GetAllProduct() {
        return FakeProducts;
    }

    @Override
    public void RemoveProduct(Product product) {
        FakeProducts.remove(product);
    }

    @Override
    public List<Product> getProductsByCategory_GenderAnAndCategory_Name(String gender, String name) {
        ArrayList<Product> temp = new ArrayList<>();
        for (Product p : FakeProducts){
            if(p.getCategory().getGender().equals(gender) && p.getCategory().getName().equals(name)){
                temp.add(p);
            }
        }
        return temp;
    }

    @Override
    public Product getProductsByArticleNumber(int newArtNumb) {
        for (Product p : FakeProducts){
            if(p.getArticleNumber() == newArtNumb){
                return p;
            }
        }
        return null;
    }
}
