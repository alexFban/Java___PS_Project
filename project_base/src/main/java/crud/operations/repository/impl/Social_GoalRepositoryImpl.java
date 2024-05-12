package crud.operations.repository.impl;

import crud.operations.entity.Social_Goal;
import crud.operations.repository.Social_GoalRepository;
import crud.operations.repository.jpa.Social_GoalJpaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class Social_GoalRepositoryImpl implements Social_GoalRepository {

    Social_GoalJpaRepo jpaRepository;

    @Override
    public Social_Goal save(Social_Goal socialGoal) {
        return jpaRepository.save(socialGoal);
    }

    @Override
    public Optional<Social_Goal> findById(Long socialGoalId) {
        return jpaRepository.findById(socialGoalId);
    }

    @Override
    public List<Social_Goal> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long socialGoalId) {
        jpaRepository.deleteById(socialGoalId);
    }
}
