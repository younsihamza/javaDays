package app;
import java.sql.Driver;
import java.time.LocalDateTime;

import javax.sql.DataSource;
import models.*;
import java.util.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import repository.MessagesRepository;
import repository.MessagesRepositoryJdbcImpl;




public class App {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://postgresdb/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        HikariDataSource dataSource = new HikariDataSource(config); 
        MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        Optional<Message> messageOptional = messagesRepository.findById(1l);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("Bye");
            message.setDateTime(null);
            messagesRepository.update(message);
        }
        dataSource.close();
    }
}
