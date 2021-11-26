package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import web_application.model.Category;

import java.util.List;

public interface ICategory extends JpaRepository<Category,Long> {
    List<Category> getCategoriesByGender(String gender);
}
