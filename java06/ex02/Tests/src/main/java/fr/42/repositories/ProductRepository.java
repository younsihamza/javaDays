package repository;
import java.util.List;
import java.util.Optional;

import models.*;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void update(Product product);
    void save(Product product);
    void delete(Long id);
}
