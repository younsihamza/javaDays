package models;

import java.time.LocalDateTime;
import java.util.*;


public class Message {
    private long  id;
    private User author;
    private Room room;
    private String text;
    private LocalDateTime time;
    
    @Override
    public String toString() {
        return "Message [id=" + id + ", author=" + author + ", room=" + room + ", text=" + text + ", time=" + time
                + "]";
    }

    @Override
    public int hashCode() {
       return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
