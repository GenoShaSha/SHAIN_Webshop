package web_application.interfaces;

import web_application.model.AnnouncementMessage;

import java.util.List;

public interface IAnnouncementService {
    void AddMessage(AnnouncementMessage message);
    List<AnnouncementMessage> GetAllMessage();
}
