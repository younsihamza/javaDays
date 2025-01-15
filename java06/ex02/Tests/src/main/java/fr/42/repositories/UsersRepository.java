package repository;
import models.*;
public interface UsersRepository {
    User findByLogin(String login);
    void update(User user);
}
