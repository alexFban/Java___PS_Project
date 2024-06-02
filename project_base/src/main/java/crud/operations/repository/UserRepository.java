package crud.operations.repository;

import crud.operations.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * An interface that defines the methods for performing CRUD operations on the User.
 */
public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long userId);

    Optional<User> findByUsername(String username);

    List<User> findAll();

    void deleteById(Long userId);
}
