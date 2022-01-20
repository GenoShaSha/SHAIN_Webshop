package web_application.interfaces;

import web_application.model.AnnouncementMessage;
import web_application.model.Category;

import java.util.List;

public interface IAnnouncementRepo {
    void AddMessage(AnnouncementMessage message);
    List<AnnouncementMessage> GetAllMessage();
}
