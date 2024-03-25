package crud.operations.repository;

import crud.operations.entity.User_Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * An interface that defines the methods for performing CRUD operations on the User_Project.
 */
public interface User_ProjectRepository extends JpaRepository<User_Project, Long> {
}
