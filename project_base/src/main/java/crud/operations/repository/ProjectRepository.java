package crud.operations.repository;

import crud.operations.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * An interface that defines the methods for performing CRUD operations on the Project.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
