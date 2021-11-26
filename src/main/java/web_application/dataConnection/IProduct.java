package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web_application.model.Member;
import web_application.model.Product;

import java.util.List;

public interface IProduct extends JpaRepository<Product,Long> {
    Product getProductsByArticleNumber(int newArtNumb);
    @Query(value = "SELECT * FROM products p WHERE Category.gender =?1 and Category.name=?2",nativeQuery = true)
    List<Product> getProductsByCategory_GenderAnAndCategory_Name(String gender,String name);
}
