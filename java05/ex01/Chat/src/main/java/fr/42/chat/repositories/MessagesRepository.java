package repository;
import java.util.Optional;

import models.Message;

public interface MessagesRepository {
    public  Optional <Message>  findById(Long id);
}
