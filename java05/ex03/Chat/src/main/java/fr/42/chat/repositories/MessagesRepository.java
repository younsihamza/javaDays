package repository;
import java.util.Optional;

import javax.sql.DataSource;

import models.Message;

public interface MessagesRepository {
    public Optional<Message> findById(Long id);
    void save(Message message);
}
