package crud.operations.repository;

import crud.operations.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * An interface that defines the methods for performing CRUD operations on the User.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
