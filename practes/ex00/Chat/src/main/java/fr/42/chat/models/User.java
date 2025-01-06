package models;
import java.util.*;
import java.util.Objects;

public class User {
    private long id;
    private String login;
    private String password;
    private List<Room> createRooms;
    private List<Room>  Rooms;

    @Override
    public boolean equels(Object obj) {
        if(obj == null || obj.getClass() != getClass())
            return false;
        if(this == Object)
            return true;
        return this.id == (User)(obj.id);
    }

    @Override
    public int hashCode() {
       return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
    }

}
