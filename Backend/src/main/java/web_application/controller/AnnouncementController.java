package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import web_application.interfaces.IAnnouncementService;
import web_application.model.AnnouncementMessage;
import web_application.model.Announcement;

import java.time.LocalDateTime;

@Controller
public class AnnouncementController {

@Autowired
    IAnnouncementService logic;

    @MessageMapping("/send")
    @SendTo("/topic/announcement")
    public AnnouncementMessage sendMessage(Announcement announcement) throws Exception{

        logic.AddMessage(new AnnouncementMessage(LocalDateTime.now() + " - " +" Attention: "+ announcement.getContent()));
        return new AnnouncementMessage(HtmlUtils.htmlEscape(LocalDateTime.now() +" - " +" Attention: "+ announcement.getContent()));
    }
}
