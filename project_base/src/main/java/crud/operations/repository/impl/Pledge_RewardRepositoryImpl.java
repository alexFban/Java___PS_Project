package crud.operations.repository.impl;

import crud.operations.entity.Pledge_Reward;
import crud.operations.repository.Pledge_RewardRepository;
import crud.operations.repository.jpa.Pledge_RewardJpaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class Pledge_RewardRepositoryImpl implements Pledge_RewardRepository {

    Pledge_RewardJpaRepo jpaRepository;

    @Override
    public Pledge_Reward save(Pledge_Reward pledgeReward) {
        return jpaRepository.save(pledgeReward);
    }

    @Override
    public Optional<Pledge_Reward> findById(Long pledgeRewardId) {
        return jpaRepository.findById(pledgeRewardId);
    }

    @Override
    public List<Pledge_Reward> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long pledgeRewardId) {
        jpaRepository.deleteById(pledgeRewardId);
    }
}
