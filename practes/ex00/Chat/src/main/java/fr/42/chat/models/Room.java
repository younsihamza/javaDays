package models;
import java.util.*;
public class Room {
    private long id;
    private String name;
    private User owner;
    private List<User> Users;

    
    @Override
    public String toString() {
        return "Room [id=" + id + ", name=" + name + ", owner=" + owner + ", Users=" + Users + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Room other = (Room) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
