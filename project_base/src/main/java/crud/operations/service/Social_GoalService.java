package crud.operations.service;

import crud.operations.entity.Social_Goal;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for Social_Goal.
 */
public interface Social_GoalService {
    /**
     * Adds new Social_Goal to the DataBase. Equivalent to the POST operation.
     * @param socialGoal The social goal data we want to be saved.
     * @return The new repository, with the saved Social_Goal.
     */
    Social_Goal createSocial_Goal(Social_Goal socialGoal);
    /**
     * Searches for a Social_Goal with the given id. Equivalent to the GET operation.
     * @param socialGoalId The social goal id we want to be searched.
     * @return The Social_Goal with the searched id (if it exists).
     */
    Social_Goal getSocial_GoalById(Long socialGoalId);
    /**
     * Gets all social goals that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Social_Goals.
     */
    List<Social_Goal> getAllSocial_Goals();
    /**
     * Adds/modifies data of an existing Social_Goal. Equivalent to the PUT operation.
     * @param socialGoal The social goal data we want to be modified.
     * @return The modified social goal data.
     */
    Social_Goal updateSocial_Goal(Social_Goal socialGoal);
    /**
     * Deletes Social_Goal with the given id. Equivalent to the DELETE operation.
     * @param socialGoalId The social goal id we want to be searched.
     */
    void deleteSocial_Goal(Long socialGoalId);
}
