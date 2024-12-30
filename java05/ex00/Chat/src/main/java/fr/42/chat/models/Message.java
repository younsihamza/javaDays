package models;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime time;
    
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
        return "message {" + "id='" + this.id + "', text='" + this.text + "', time='"+this.time +"'";
    }
}
