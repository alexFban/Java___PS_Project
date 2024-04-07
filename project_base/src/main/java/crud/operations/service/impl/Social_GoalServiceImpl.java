package crud.operations.service.impl;

import crud.operations.entity.Project;
import crud.operations.entity.Social_Goal;
import crud.operations.repository.Social_GoalRepository;
import crud.operations.repository.UserRepository;
import crud.operations.service.Social_GoalService;
import crud.operations.service.Social_RewardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A class that implements {@link Social_GoalService} interface methods.
 */
@Service
@AllArgsConstructor
public class Social_GoalServiceImpl implements Social_GoalService {

    /**
     * Instance of {@link Social_GoalRepository} class
     */
    private Social_GoalRepository socialGoalRepository;

    /**
     * Adds new Social_Goal to the DataBase. Equivalent to the POST operation.
     * @param socialGoal The social goal data we want to be saved.
     * @return The new repository, with the saved Social_Goal.
     */
    @Override
    public Social_Goal createSocial_Goal(Social_Goal socialGoal) { return socialGoalRepository.save(socialGoal); }

    /**
     * Searches for a Social_Goal with the given id. Equivalent to the GET operation.
     * @param socialGoalId The social goal id we want to be searched.
     * @return The Social_Goal with the searched id (if it exists).
     */
    @Override
    public Social_Goal getSocial_GoalById(Long socialGoalId) {
        Optional<Social_Goal> optionalSocial_Goal = socialGoalRepository.findById(socialGoalId);
        return optionalSocial_Goal.get();
    }

    /**
     * Gets all social goals that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Social_Goals.
     */
    @Override
    public List<Social_Goal> getAllSocial_Goals() { return socialGoalRepository.findAll(); }

    /**
     * Adds/modifies data of an existing Social_Goal. Equivalent to the PUT operation.
     * @param socialGoal The social goal data we want to be modified.
     * @return The modified social goal data.
     */
    @Override
    public Social_Goal updateSocial_Goal(Social_Goal socialGoal) {
        Social_Goal existingSocial_Goal = socialGoalRepository.findById(socialGoal.getId()).get();
        existingSocial_Goal.setNumber_achieved(socialGoal.getNumber_achieved() == 0 ?
                                            existingSocial_Goal.getNumber_achieved() : socialGoal.getNumber_achieved());
        existingSocial_Goal.setNumber_to_achieve(socialGoal.getNumber_to_achieve() == 0 ?
                                                existingSocial_Goal.getNumber_to_achieve() : socialGoal.getNumber_to_achieve());
        existingSocial_Goal.setDescription(socialGoal.getDescription() == null ?
                                        existingSocial_Goal.getDescription() : socialGoal.getDescription());
        Social_Goal updatedSocial_Goal = socialGoalRepository.save(existingSocial_Goal);
        updatedSocial_Goal.getProject().update("A social goal of project " + updatedSocial_Goal.getProject().getName() + " has been updated!");
        return updatedSocial_Goal;
    }

    /**
     * Deletes Social_Goal with the given id. Equivalent to the DELETE operation.
     * @param socialGoalId The social goal id we want to be searched.
     */
    @Override
    public void deleteSocial_Goal(Long socialGoalId) { socialGoalRepository.deleteById(socialGoalId); }
}
