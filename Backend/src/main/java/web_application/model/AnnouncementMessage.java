package web_application.model;

import lombok.Builder;


public class AnnouncementMessage {
    private String message;

    private AnnouncementMessage(){

    }

    public AnnouncementMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
