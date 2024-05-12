package crud.operations.repository;

import crud.operations.entity.Social_Goal;
import crud.operations.entity.Social_Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * An interface that defines the methods for performing CRUD operations on the Social_Goal.
 */
public interface Social_GoalRepository  {
    public Social_Goal save(Social_Goal socialGoal);

    public Optional<Social_Goal> findById(Long socialGoalId);

    public List<Social_Goal> findAll();

    public void deleteById(Long socialGoalId);
}
