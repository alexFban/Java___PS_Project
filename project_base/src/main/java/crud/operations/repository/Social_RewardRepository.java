package crud.operations.repository;

import crud.operations.entity.Social_Reward;

import java.util.List;
import java.util.Optional;

/**
 * An interface that defines the methods for performing CRUD operations on the Social_Reward.
 */
public interface Social_RewardRepository {
    public Social_Reward save(Social_Reward socialReward);

    public Optional<Social_Reward> findById(Long socialRewardId);

    public List<Social_Reward> findAll();

    public void deleteById(Long socialRewardId);
}
