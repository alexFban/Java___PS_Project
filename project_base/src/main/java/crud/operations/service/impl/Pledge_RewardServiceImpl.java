package crud.operations.service.impl;

import crud.operations.entity.Pledge_Reward;
import crud.operations.repository.Pledge_RewardRepository;
import crud.operations.repository.UserRepository;
import crud.operations.service.Pledge_RewardService;
import crud.operations.service.Social_RewardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A class that implements {@link Pledge_RewardService} interface methods.
 */
@Service
@AllArgsConstructor
public class Pledge_RewardServiceImpl implements Pledge_RewardService {

    /**
     * Instance of {@link Pledge_RewardRepository} class
     */
    private Pledge_RewardRepository pledgeRewardRepository;

    /**
     * Adds new Pledge_Reward to the DataBase. Equivalent to the POST operation.
     * @param pledgeReward The pledge reward data we want to be saved.
     * @return The new repository, with the saved Pledge_Reward.
     */
    @Override
    public Pledge_Reward createPledge_Reward(Pledge_Reward pledgeReward) { return pledgeRewardRepository.save(pledgeReward); }

    /**
     * Searches for a Pledge_Reward with the given id. Equivalent to the GET operation.
     * @param pledgeRewardId The pledge reward id we want to be searched.
     * @return The Pledge_Reward with the searched id (if it exists).
     */
    @Override
    public Pledge_Reward getPledge_RewardById(Long pledgeRewardId) {
        Optional<Pledge_Reward> optionalPledgeReward = pledgeRewardRepository.findById(pledgeRewardId);
        return optionalPledgeReward.get();
    }

    /**
     * Gets all pledge rewards that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Pledge_Rewards.
     */
    @Override
    public List<Pledge_Reward> getAllPledge_Rewards() { return pledgeRewardRepository.findAll(); }

    /**
     * Adds/modifies data of an existing Pledge_Reward. Equivalent to the PUT operation.
     * @param pledgeReward The pledge reward data we want to be modified.
     * @return The modified pledge reward data.
     */
    @Override
    public Pledge_Reward updatePledge_Reward(Pledge_Reward pledgeReward) {
        Pledge_Reward existingPledgeReward = pledgeRewardRepository.findById(pledgeReward.getId()).get();
        existingPledgeReward.setItem(pledgeReward.getItem() == null ?
                                    existingPledgeReward.getItem() : pledgeReward.getItem());
        existingPledgeReward.setMinimum_pledge_level(pledgeReward.getMinimum_pledge_level() == 0 ?
                                                    existingPledgeReward.getMinimum_pledge_level() : pledgeReward.getMinimum_pledge_level());
        existingPledgeReward.setDescription(pledgeReward.getDescription() == null ?
                                            existingPledgeReward.getDescription() : pledgeReward.getDescription());
        Pledge_Reward updatedPledge_Reward = pledgeRewardRepository.save(existingPledgeReward);
        updatedPledge_Reward.getProject().update("A pledge reward of project " + updatedPledge_Reward.getProject().getName() + " has been updated!");
        return updatedPledge_Reward;
    }

    /**
     * Deletes Pledge_Reward with the given id. Equivalent to the DELETE operation.
     * @param pledgeRewardId The pledge reward id we want to be searched.
     */
    @Override
    public void deletePledge_Reward(Long pledgeRewardId) { pledgeRewardRepository.deleteById(pledgeRewardId); }
}
