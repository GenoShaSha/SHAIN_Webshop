package web_application.model;

public class Announcement {
    private String content;

    public Announcement(){

    }

    public Announcement(String newContent){
        this.content = newContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
