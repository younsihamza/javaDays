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
        Optional<Message> message = Optional.empty();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            ResultSet rs = statement.executeQuery();
            rs.next();
            message = Optional.of(new Message(Long.valueOf(rs.getString("message_id")), null, null, rs.getString("message_text"),  LocalDateTime.parse(rs.getString("message_time"), formatter)));
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } 
        return message;
    }
}
