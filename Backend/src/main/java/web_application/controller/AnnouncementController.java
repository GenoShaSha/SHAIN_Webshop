package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import web_application.interfaces.IAnnouncementService;
import web_application.model.AnnouncementMessage;
import web_application.model.Announcement;
import web_application.model.Member;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Controller
public class AnnouncementController {

@Autowired
    IAnnouncementService logic;

    @MessageMapping("/send")
    @SendTo("/topic/announcement")
    public AnnouncementMessage sendMessage(Announcement announcement) throws Exception{

        logic.AddMessage(new AnnouncementMessage(LocalDateTime.now().toLocalDate() + " - " +" Attention: "+ announcement.getContent()));
        return new AnnouncementMessage(HtmlUtils.htmlEscape(LocalDateTime.now().toLocalDate() +" - " +" Attention: "+ announcement.getContent()));
    }

    @GetMapping("/announcement")
    public ResponseEntity<List<AnnouncementMessage>> getAllMessage() {
        return ResponseEntity.ok().body(logic.GetAllMessage());
    }

}
