package web_application.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "annoucements")
@NoArgsConstructor
public class AnnouncementMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;

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
