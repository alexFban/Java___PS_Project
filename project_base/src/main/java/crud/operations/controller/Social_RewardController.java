package crud.operations.controller;

import crud.operations.entity.Social_Reward;
import crud.operations.entity.User;
import crud.operations.service.Social_RewardService;
import crud.operations.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class that builds CRUD REST APIs for the {@link Social_Reward} resource.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/social_rewards")
public class Social_RewardController {

    /**
     * Instance of {@link Social_RewardService} class.
     */
    private Social_RewardService socialRewardService;

    /**
     * POST REST API.
     * @param socialReward The social reward data to be added to the DataBase.
     * @return The response to the operation.
     */
    @PostMapping
    public ResponseEntity<Social_Reward> createSocial_Reward(@RequestBody Social_Reward socialReward) {
        Social_Reward saveSocial_Reward = socialRewardService.createSocial_Reward(socialReward);
        return new ResponseEntity<>(saveSocial_Reward, HttpStatus.CREATED);
    }

    /**
     * GET REST API (with id parameter).
     * @param socialRewardId The Social Reward ID to be searched.
     * @return The response to the operation.
     */
    @GetMapping("{id}")
    public ResponseEntity<Social_Reward> getSocial_RewardById(@PathVariable("id") Long socialRewardId) {
        Social_Reward socialReward = socialRewardService.getSocial_RewardById(socialRewardId);
        return new ResponseEntity<>(socialReward, HttpStatus.OK);
    }

    /**
     * GET REST API (with no parameters).
     * @return The response to the operation.
     */
    @GetMapping
    public ResponseEntity<List<Social_Reward>> getAllSocial_Rewards() {
        List<Social_Reward> socialRewards = socialRewardService.getAllSocial_Rewards();
        return new ResponseEntity<>(socialRewards, HttpStatus.OK);
    }

    /**
     * PUT REST API.
     * @param socialRewardId The social reward id to be searched.
     * @param socialReward The new social reward data to be modified.
     * @return The response to the operation.
     */
    @PutMapping("{id}")
    public ResponseEntity<Social_Reward> updateSocial_Reward(@PathVariable("id") Long socialRewardId,
                                                         @RequestBody Social_Reward socialReward) {
        socialReward.setId(socialRewardId);
        Social_Reward updatedSocial_Reward = socialRewardService.updateSocial_Reward(socialReward);
        return new ResponseEntity<>(updatedSocial_Reward, HttpStatus.OK);
    }

    /**
     * DELETE REST API.
     * @param socialRewardId The social reward id to be searched.
     * @return The response to the operation.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSocial_Reward(@PathVariable("id") Long socialRewardId) {
        socialRewardService.deleteSocial_Reward(socialRewardId);
        return new ResponseEntity<>("Social Reward successfully deleted!", HttpStatus.OK);
    }
}
