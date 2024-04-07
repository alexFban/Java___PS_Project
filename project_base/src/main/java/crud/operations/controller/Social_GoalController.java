package crud.operations.controller;

import crud.operations.entity.Social_Goal;
import crud.operations.entity.User;
import crud.operations.service.Social_GoalService;
import crud.operations.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class that builds CRUD REST APIs for the {@link Social_Goal} resource.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/social_goals")
public class Social_GoalController {

    /**
     * Instance of {@link Social_GoalService} class.
     */
    private Social_GoalService socialGoalService;

    /**
     * POST REST API.
     * @param socialGoal The social goal data to be added to the DataBase.
     * @return The response to the operation.
     */
    @PostMapping
    public ResponseEntity<Social_Goal> createSocial_Goal(@RequestBody Social_Goal socialGoal) {
        Social_Goal saveSocial_Goal = socialGoalService.createSocial_Goal(socialGoal);
        return new ResponseEntity<>(saveSocial_Goal, HttpStatus.CREATED);
    }

    /**
     * GET REST API (with id parameter).
     * @param socialGoalId The Social Goal ID to be searched.
     * @return The response to the operation.
     */
    @GetMapping("{id}")
    public ResponseEntity<Social_Goal> getSocial_GoalById(@PathVariable("id") Long socialGoalId) {
        Social_Goal socialGoal = socialGoalService.getSocial_GoalById(socialGoalId);
        return new ResponseEntity<>(socialGoal, HttpStatus.OK);
    }

    /**
     * GET REST API (with no parameters).
     * @return The response to the operation.
     */
    @GetMapping
    public ResponseEntity<List<Social_Goal>> getAllSocial_Goals() {
        List<Social_Goal> socialGoals = socialGoalService.getAllSocial_Goals();
        return new ResponseEntity<>(socialGoals, HttpStatus.OK);
    }

    /**
     * PUT REST API.
     * @param socialGoalId The social goal id to be searched.
     * @param socialGoal The new social goal data to be modified.
     * @return The response to the operation.
     */
    @PutMapping("{id}")
    public ResponseEntity<Social_Goal> updateSocial_Goal(@PathVariable("id") Long socialGoalId,
                                                             @RequestBody Social_Goal socialGoal) {
        socialGoal.setId(socialGoalId);
        Social_Goal updatedSocial_Goal = socialGoalService.updateSocial_Goal(socialGoal);
        return new ResponseEntity<>(updatedSocial_Goal, HttpStatus.OK);
    }

    /**
     * DELETE REST API.
     * @param socialGoalId The social goal id to be searched.
     * @return The response to the operation.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSocial_Goal(@PathVariable("id") Long socialGoalId) {
        socialGoalService.deleteSocial_Goal(socialGoalId);
        return new ResponseEntity<>("Social Goal successfully deleted!", HttpStatus.OK);
    }
}
