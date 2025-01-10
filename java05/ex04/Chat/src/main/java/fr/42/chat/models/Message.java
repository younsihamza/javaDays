package models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long id;
    
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime dateTime;
    
    
    public Message(Long id, User author, Chatroom room, String text , LocalDateTime time) {
        this.id     = id;
        this.author = author;
        this.room   = room;
        this.text   = text;
        this.dateTime   = dateTime;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != getClass())
            return false;
        if(this == obj)
            return true;
            Message objMessage = (Message) obj;
        return Objects.equals(id, objMessage.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }
    
    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
        return "message {" + "id='" + this.id + "', text='" + this.text + "', time='"+this.dateTime.format(format) +"' }";
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
