package app;
import java.sql.Driver;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.sql.DataSource;
import models.*;
import java.util.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import models.Chatroom;
import repository.MessagesRepositoryJdbcImpl;




public class App {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://postgresdb/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        HikariDataSource dataSource = new HikariDataSource(config); 
        User creator = new User(1L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(1L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        MessagesRepositoryJdbcImpl messageJdbc = new MessagesRepositoryJdbcImpl(dataSource);
        messageJdbc.save(message);
        System.out.println("id : " + message.getId());
        dataSource.close();
    }
}
