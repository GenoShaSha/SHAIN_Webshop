package web_application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web_application.dataConnection.IAnnoucement;
import web_application.interfaces.IAnnouncementRepo;
import web_application.model.AnnouncementMessage;

import java.util.List;

@Repository
public class AnnoucementRepo implements IAnnouncementRepo {
    @Autowired
    IAnnoucement repo;
    @Override
    public void AddMessage(AnnouncementMessage message) {
        repo.save(message);
    }

    @Override
    public List<AnnouncementMessage> GetAllMessage() {
        return repo.findAll();
    }
}
