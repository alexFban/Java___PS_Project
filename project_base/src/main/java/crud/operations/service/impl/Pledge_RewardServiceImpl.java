package crud.operations.service.impl;

import crud.operations.entity.Pledge_Reward;
import crud.operations.repository.Pledge_RewardRepository;
import crud.operations.service.Pledge_RewardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Pledge_RewardServiceImpl implements Pledge_RewardService {
    private Pledge_RewardRepository pledgeRewardRepository;
    @Override
    public Pledge_Reward createPledge_Reward(Pledge_Reward pledgeReward) { return pledgeRewardRepository.save(pledgeReward); }
    @Override
    public Pledge_Reward getPledge_RewardById(Long pledgeRewardId) {
        Optional<Pledge_Reward> optionalPledgeReward = pledgeRewardRepository.findById(pledgeRewardId);
        return optionalPledgeReward.get();
    }
    @Override
    public List<Pledge_Reward> getAllPledge_Rewards() { return pledgeRewardRepository.findAll(); }
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
    @Override
    public void deletePledge_Reward(Long pledgeRewardId) { pledgeRewardRepository.deleteById(pledgeRewardId); }
}
