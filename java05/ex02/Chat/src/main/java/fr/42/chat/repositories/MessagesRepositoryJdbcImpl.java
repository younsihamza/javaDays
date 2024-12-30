package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.sql.DataSource;
import models.Message;

public class MessagesRepositoryJdbcImpl  implements MessagesRepository {
        private DataSource dataSource; 
        public MessagesRepositoryJdbcImpl(DataSource dataSource) {
            this.dataSource = dataSource;
            
        }

    public Optional <Message> findById(Long id) {
        String query = "SELECT * FROM message WHERE message_id=" + id ;
        Message message = Optional.empty();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            ResultSet rs = statement.executeQuery();
            rs.next();
            message = Optional.of(new Message(Long.valueOf(rs.getString("message_id")), null, null, rs.getString("message_text"),  LocalDateTime.parse(rs.getString("message_time"), formatter)));
        } catch(Exception e) {
            System.out.println("ERROR : "  + e.getMessage());
        } 
        return message;
    }
    
    class NotSavedSubEntityException extends RuntimeException {
        public NotSavedSubEntityException(String message){
            super(message);
        }
    }

    public void save(Message message) {
        try(Connection connection = dataSource.getConnection()){
    
                if(message ==  null || message.getAuthor() == null || message.getRoom() == null)
                    throw new NotSavedSubEntityException("message , auther or room is null");
                
                String query = "SELECT * FROM users WHERE user_id = " + message.getAuthor().getId();
                try(PreparedStatement statement = connection.prepareStatement(query)) {
                    try(ResultSet rs = statement.executeQuery()) {
                        if(!rs.next())
                            throw new NotSavedSubEntityException("user with what id not found");
                    }
                }
                query = "SELECT * FROM chatroom WHERE chatroom_id = " + message.getRoom().getId();
                try(PreparedStatement statement = connection.prepareStatement(query)) {
                    try(ResultSet rs = statement.executeQuery()){
                        if(!rs.next())
                            throw new NotSavedSubEntityException("room with that id not found");
                    }
                }
                query = "INSERT INTO message (Message_author, Message_room, Message_text) VALUES ( ?, ?, ? )" ;
                try ( PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
                    statement.setLong(1, message.getAuthor().getId());
                    statement.setLong(2, message.getRoom().getId());
                    statement.setString(3, message.getText());
                    int numberOfRows = statement.executeUpdate();
                    if (numberOfRows == 0)
                        throw new NotSavedSubEntityException("recored not added to  database");
                    try(ResultSet rs = statement.getGeneratedKeys()){
                        if(rs.next())
                            message.setId(rs.getLong(1));
                    }
                }
            
        } catch(Exception e) {
            throw new NotSavedSubEntityException("ERROR : " + e.getMessage());
        }
        
    }
}
