package crud.operations.service;

import crud.operations.entity.Social_Reward;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for Social_Reward.
 */
public interface Social_RewardService {
    /**
     * Adds new Social_Reward to the DataBase. Equivalent to the POST operation.
     * @param socialReward The social reward data we want to be saved.
     * @return The new repository, with the saved Social_Reward.
     */
    Social_Reward createSocial_Reward(Social_Reward socialReward);
    /**
     * Searches for a Social_Reward with the given id. Equivalent to the GET operation.
     * @param socialRewardId The social reward id we want to be searched.
     * @return The Social_Reward with the searched id (if it exists).
     */
    Social_Reward getSocial_RewardById(Long socialRewardId);
    /**
     * Gets all social rewards that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Social_Rewards.
     */
    List<Social_Reward> getAllSocial_Rewards();
    /**
     * Adds/modifies data of an existing Social_Reward. Equivalent to the PUT operation.
     * @param socialReward The social reward data we want to be modified.
     * @return The modified social reward data.
     */
    Social_Reward updateSocial_Reward(Social_Reward socialReward);
    /**
     * Deletes Social_Reward with the given id. Equivalent to the DELETE operation.
     * @param socialRewardId The social reward id we want to be searched.
     */
    void deleteSocial_Reward(Long socialRewardId);
}
