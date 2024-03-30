package crud.operations.controller;

import crud.operations.entity.Social_Goal;
import crud.operations.service.Social_GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/social_goals")
public class Social_GoalController {
    private Social_GoalService socialGoalService;
    @PostMapping
    public ResponseEntity<Social_Goal> createSocial_Goal(@RequestBody Social_Goal socialGoal) {
        Social_Goal saveSocial_Goal = socialGoalService.createSocial_Goal(socialGoal);
        return new ResponseEntity<>(saveSocial_Goal, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Social_Goal> getSocial_GoalById(@PathVariable("id") Long socialGoalId) {
        Social_Goal socialGoal = socialGoalService.getSocial_GoalById(socialGoalId);
        return new ResponseEntity<>(socialGoal, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Social_Goal>> getAllSocial_Goals() {
        List<Social_Goal> socialGoals = socialGoalService.getAllSocial_Goals();
        return new ResponseEntity<>(socialGoals, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Social_Goal> updateSocial_Goal(@PathVariable("id") Long socialGoalId,
                                                             @RequestBody Social_Goal socialGoal) {
        socialGoal.setId(socialGoalId);
        Social_Goal updatedSocial_Goal = socialGoalService.updateSocial_Goal(socialGoal);
        return new ResponseEntity<>(updatedSocial_Goal, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSocial_Goal(@PathVariable("id") Long socialGoalId) {
        socialGoalService.deleteSocial_Goal(socialGoalId);
        return new ResponseEntity<>("Social Goal successfully deleted!", HttpStatus.OK);
    }
}
