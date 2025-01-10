import java.util.List;

import models.User;

public interface UsersRepository {
    List<User> findAll(int page, int size);
}
