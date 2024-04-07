package crud.operations.service.impl;

import crud.operations.entity.Social_Reward;
import crud.operations.repository.Social_RewardRepository;
import crud.operations.repository.UserRepository;
import crud.operations.service.Social_RewardService;
import crud.operations.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A class that implements {@link Social_RewardService} interface methods.
 */
@Service
@AllArgsConstructor
public class Social_RewardServiceImpl implements Social_RewardService {

    /**
     * Instance of {@link Social_RewardRepository} class
     */
    private Social_RewardRepository socialRewardRepository;

    /**
     * Adds new Social_Reward to the DataBase. Equivalent to the POST operation.
     * @param socialReward The social reward data we want to be saved.
     * @return The new repository, with the saved Social_Reward.
     */
    @Override
    public Social_Reward createSocial_Reward(Social_Reward socialReward) { return socialRewardRepository.save(socialReward); }

    /**
     * Searches for a Social_Reward with the given id. Equivalent to the GET operation.
     * @param socialRewardId The social reward id we want to be searched.
     * @return The Social_Reward with the searched id (if it exists).
     */
    @Override
    public Social_Reward getSocial_RewardById(Long socialRewardId) {
        Optional<Social_Reward> optionalSocial_Reward = socialRewardRepository.findById(socialRewardId);
        return optionalSocial_Reward.get();
    }

    /**
     * Gets all social rewards that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Social_Rewards.
     */
    @Override
    public List<Social_Reward> getAllSocial_Rewards() { return socialRewardRepository.findAll(); }

    /**
     * Adds/modifies data of an existing Social_Reward. Equivalent to the PUT operation.
     * @param socialReward The social reward data we want to be modified.
     * @return The modified social reward data.
     */
    @Override
    public Social_Reward updateSocial_Reward(Social_Reward socialReward) {
        Social_Reward existingSocial_Reward = socialRewardRepository.findById(socialReward.getId()).get();
        existingSocial_Reward.setDescription(socialReward.getDescription() == null ?
                                            existingSocial_Reward.getDescription() : socialReward.getDescription());
        Social_Reward updatedSocial_Reward = socialRewardRepository.save(existingSocial_Reward);
        return updatedSocial_Reward;
    }

    /**
     * Deletes Social_Reward with the given id. Equivalent to the DELETE operation.
     * @param socialRewardId The social reward id we want to be searched.
     */
    @Override
    public void deleteSocial_Reward(Long socialRewardId) { socialRewardRepository.deleteById(socialRewardId); }
}
