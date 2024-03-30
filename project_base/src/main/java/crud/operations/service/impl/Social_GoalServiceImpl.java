package crud.operations.service.impl;

import crud.operations.entity.Social_Goal;
import crud.operations.repository.Social_GoalRepository;
import crud.operations.service.Social_GoalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Social_GoalServiceImpl implements Social_GoalService {
    private Social_GoalRepository socialGoalRepository;
    @Override
    public Social_Goal createSocial_Goal(Social_Goal socialGoal) { return socialGoalRepository.save(socialGoal); }
    @Override
    public Social_Goal getSocial_GoalById(Long socialGoalId) {
        Optional<Social_Goal> optionalSocial_Goal = socialGoalRepository.findById(socialGoalId);
        return optionalSocial_Goal.get();
    }
    @Override
    public List<Social_Goal> getAllSocial_Goals() { return socialGoalRepository.findAll(); }
    @Override
    public Social_Goal updateSocial_Goal(Social_Goal socialGoal) {
        Social_Goal existingSocial_Goal = socialGoalRepository.findById(socialGoal.getId()).get();
        existingSocial_Goal.setNumber_achieved(socialGoal.getNumber_achieved());
        existingSocial_Goal.setNumber_to_achieve(socialGoal.getNumber_to_achieve());
        existingSocial_Goal.setDescription(socialGoal.getDescription());
        Social_Goal updatedSocial_Goal = socialGoalRepository.save(existingSocial_Goal);
        return updatedSocial_Goal;
    }
    @Override
    public void deleteSocial_Goal(Long socialGoalId) { socialGoalRepository.deleteById(socialGoalId); }
}
