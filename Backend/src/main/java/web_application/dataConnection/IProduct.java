package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web_application.model.Member;
import web_application.model.Product;

import java.util.List;

public interface IProduct extends JpaRepository<Product,Long> {
    Product getProductsByArticleNumber(int newArtNumb);
    List<Product> getProductsByCategory_GenderAndCategory_Name(String gender,String name);
    List<Product> getProductsByCategory_GenderAndCategory_NameAndProductName(String gender,String catName, String prodName);
}
