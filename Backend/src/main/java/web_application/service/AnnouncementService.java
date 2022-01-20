package web_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_application.interfaces.IAnnouncementRepo;
import web_application.interfaces.IAnnouncementService;
import web_application.model.AnnouncementMessage;

import java.util.List;

@Service
public class AnnouncementService implements IAnnouncementService {
    @Autowired
    IAnnouncementRepo repo;
    @Override
    public void AddMessage(AnnouncementMessage message) {
        if(message != null){
            repo.AddMessage(message);
        }
    }

    @Override
    public List<AnnouncementMessage> GetAllMessage() {
        return repo.GetAllMessage();
    }
}
