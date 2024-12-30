package app;
import java.sql.Driver;
import java.util.Optional;
import java.util.Scanner;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import models.Message;
import repository.MessagesRepositoryJdbcImpl;




public class App {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://postgresdb/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        Scanner scanner = new Scanner(System.in);
        long messageId = scanner.nextInt();
        HikariDataSource dataSource = new HikariDataSource(config); 
        MessagesRepositoryJdbcImpl messageJdbc = new MessagesRepositoryJdbcImpl(dataSource);
        Optional<Message> messageOp = messageJdbc.findById(messageId);
        messageOp.ifPresentOrElse(message -> {
            System.out.println(messageOp.get().toString());
        }, ()-> System.out.println("id not found"));
            
        dataSource.close();
    }
}
