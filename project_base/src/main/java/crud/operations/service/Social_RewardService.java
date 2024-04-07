package crud.operations.service;

import crud.operations.entity.Social_Reward;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for Social_Reward.
 */
public interface Social_RewardService {
    Social_Reward createSocial_Reward(Social_Reward socialReward);
    Social_Reward getSocial_RewardById(Long socialRewardId);
    List<Social_Reward> getAllSocial_Rewards();
    Social_Reward updateSocial_Reward(Social_Reward socialReward);
    void deleteSocial_Reward(Long socialRewardId);
}
