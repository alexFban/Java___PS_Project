package crud.operations.service;

import crud.operations.entity.Pledge_Reward;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for Pledge_Reward.
 */
public interface Pledge_RewardService {
    /**
     * Adds new Pledge_Reward to the DataBase. Equivalent to the POST operation.
     * @param pledgeReward The pledge reward data we want to be saved.
     * @return The new repository, with the saved Pledge_Reward.
     */
    Pledge_Reward createPledge_Reward(Pledge_Reward pledgeReward);
    /**
     * Searches for a Pledge_Reward with the given id. Equivalent to the GET operation.
     * @param pledgeRewardId The pledge reward id we want to be searched.
     * @return The Pledge_Reward with the searched id (if it exists).
     */
    Pledge_Reward getPledge_RewardById(Long pledgeRewardId);
    /**
     * Gets all pledge rewards that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Pledge_Rewards.
     */
    List<Pledge_Reward> getAllPledge_Rewards();
    /**
     * Adds/modifies data of an existing Pledge_Reward. Equivalent to the PUT operation.
     * @param pledgeReward The pledge reward data we want to be modified.
     * @return The modified pledge reward data.
     */
    Pledge_Reward updatePledge_Reward(Pledge_Reward pledgeReward);
    /**
     * Deletes Pledge_Reward with the given id. Equivalent to the DELETE operation.
     * @param pledgeRewardId The pledge reward id we want to be searched.
     */
    void deletePledge_Reward(Long pledgeRewardId);
}
