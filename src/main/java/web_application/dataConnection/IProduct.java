package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import web_application.model.Member;
import web_application.model.Product;

public interface IProduct extends JpaRepository<Product,Long> {
}
