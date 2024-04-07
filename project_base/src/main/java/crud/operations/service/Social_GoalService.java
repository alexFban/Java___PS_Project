package crud.operations.service;

import crud.operations.entity.Social_Goal;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for Social_Goal.
 */
public interface Social_GoalService {
    Social_Goal createSocial_Goal(Social_Goal socialGoal);
    Social_Goal getSocial_GoalById(Long socialGoalId);
    List<Social_Goal> getAllSocial_Goals();
    Social_Goal updateSocial_Goal(Social_Goal socialGoal);
    void deleteSocial_Goal(Long socialGoalId);
}
