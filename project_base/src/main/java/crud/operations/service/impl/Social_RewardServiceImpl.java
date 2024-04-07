package crud.operations.service.impl;

import crud.operations.entity.Social_Reward;
import crud.operations.repository.Social_RewardRepository;
import crud.operations.service.Social_RewardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Social_RewardServiceImpl implements Social_RewardService {
    private Social_RewardRepository socialRewardRepository;
    @Override
    public Social_Reward createSocial_Reward(Social_Reward socialReward) { return socialRewardRepository.save(socialReward); }
    @Override
    public Social_Reward getSocial_RewardById(Long socialRewardId) {
        Optional<Social_Reward> optionalSocial_Reward = socialRewardRepository.findById(socialRewardId);
        return optionalSocial_Reward.get();
    }
    @Override
    public List<Social_Reward> getAllSocial_Rewards() { return socialRewardRepository.findAll(); }
    @Override
    public Social_Reward updateSocial_Reward(Social_Reward socialReward) {
        Social_Reward existingSocial_Reward = socialRewardRepository.findById(socialReward.getId()).get();
        existingSocial_Reward.setDescription(socialReward.getDescription() == null ?
                                            existingSocial_Reward.getDescription() : socialReward.getDescription());
        Social_Reward updatedSocial_Reward = socialRewardRepository.save(existingSocial_Reward);
        return updatedSocial_Reward;
    }
    @Override
    public void deleteSocial_Reward(Long socialRewardId) { socialRewardRepository.deleteById(socialRewardId); }
}
