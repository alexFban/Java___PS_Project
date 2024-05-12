package crud.operations.repository;

import crud.operations.entity.Pledge_Reward;

import java.util.List;
import java.util.Optional;

/**
 * An interface that defines the methods for performing CRUD operations on the Pledge_Reward.
 */
public interface Pledge_RewardRepository {
    public Pledge_Reward save(Pledge_Reward pledgeReward);

    public Optional<Pledge_Reward> findById(Long pledgeRewardId);

    public List<Pledge_Reward> findAll();

    public void deleteById(Long pledgeRewardId);
}
