package models;
import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> messages;
    private List<User> users;

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        return this == obj || Objects.equals(((Chatroom)obj).id, this.id);
    }

    @Override
    public String toString() {
        return "chatroom { id='" + this.id + "', name='" + this.name + "'"; 
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
