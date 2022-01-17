package web_application.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import web_application.model.AnnouncementMessage;
import web_application.model.Announcement;

@Controller
public class ChatController {
    @MessageMapping("/send")
    @SendTo("/topic/announcement")
    public AnnouncementMessage sendMessage(Announcement announcement) throws Exception{
        return new AnnouncementMessage(HtmlUtils.htmlEscape( " - " +" Attention: "+ announcement.getContent()));
    }
}
