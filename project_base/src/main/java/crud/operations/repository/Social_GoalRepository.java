package crud.operations.repository;

import crud.operations.entity.Social_Goal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * An interface that defines the methods for performing CRUD operations on the Social_Goal.
 */
public interface Social_GoalRepository extends JpaRepository<Social_Goal, Long> {
}
