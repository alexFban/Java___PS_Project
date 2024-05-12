package crud.operations.repository.impl;

import crud.operations.entity.Social_Reward;
import crud.operations.repository.Social_RewardRepository;
import crud.operations.repository.jpa.Social_RewardJpaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class Social_RewardRepositoryImpl implements Social_RewardRepository {

    Social_RewardJpaRepo jpaRepository;

    @Override
    public Social_Reward save(Social_Reward socialReward) {
        return jpaRepository.save(socialReward);
    }

    @Override
    public Optional<Social_Reward> findById(Long socialRewardId) {
        return jpaRepository.findById(socialRewardId);
    }

    @Override
    public List<Social_Reward> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long socialRewardId) {
        jpaRepository.deleteById(socialRewardId);
    }
}
