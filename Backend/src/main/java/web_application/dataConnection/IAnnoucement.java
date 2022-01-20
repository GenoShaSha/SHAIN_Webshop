package web_application.dataConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import web_application.model.AnnouncementMessage;
import web_application.model.Category;

public interface IAnnoucement extends JpaRepository<AnnouncementMessage,Long> {
}
