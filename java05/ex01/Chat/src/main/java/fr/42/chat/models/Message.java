package models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime time;

    public Message(Long id, User author, Chatroom room, String text , LocalDateTime time) {
        this.id     = id;
        this.author = author;
        this.room   = room;
        this.text   = text;
        this.time   = time;
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
        return "message {" + "id='" + this.id + "', text='" + this.text + "', time='"+this.time.format(format) +"' }";
    }
}
