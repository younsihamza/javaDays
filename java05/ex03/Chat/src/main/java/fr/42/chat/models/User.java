package models;
import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<Chatroom> rooms;
    private List<Chatroom> chatrooms;
     
    public User(Long id, String login, String password, List<Chatroom> rooms, List<Chatroom> chatrooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rooms = rooms;
        this.chatrooms = chatrooms;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null  || getClass() != obj.getClass())
            return false;
        if(this == obj)
            return true;
        User objUser = (User)obj;
        return id == objUser.id;
    }
    @Override
    public int hashCode(){
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString(){
        return "user { id='" + this.id + "', login='" + this.login + "', password='" + this.password + "' }"; 
    }
    public Long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public List<Chatroom> getRooms() {
        return rooms;
    }
    public List<Chatroom> getChatrooms() {
        return chatrooms;
    }

}