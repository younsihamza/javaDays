package models;
import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<Chatroom> rooms;
    private List<Chatroom> chatrooms;
     
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

}