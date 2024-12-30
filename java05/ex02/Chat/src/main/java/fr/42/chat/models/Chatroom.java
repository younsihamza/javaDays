package models;
import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> messages;
    private List<User> users;

    public Chatroom(Long id, String name, User owner, List<User> users) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.users = users;
    }

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<User> getUsers() {
        return users;
    }
}
