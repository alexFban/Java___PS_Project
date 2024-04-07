package crud.operations.controller;

import crud.operations.entity.Pledge_Reward;
import crud.operations.entity.User;
import crud.operations.service.Pledge_RewardService;
import crud.operations.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class that builds CRUD REST APIs for the {@link Pledge_Reward} resource.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/pledge_rewards")
public class Pledge_RewardController {

    /**
     * Instance of {@link Pledge_RewardService} class.
     */
    private Pledge_RewardService pledgeRewardService;

    /**
     * POST REST API.
     * @param pledgeReward The pledge reward data to be added to the DataBase.
     * @return The response to the operation.
     */
    @PostMapping
    public ResponseEntity<Pledge_Reward> createPledge_Reward(@RequestBody Pledge_Reward pledgeReward) {
        Pledge_Reward savePledge_Reward = pledgeRewardService.createPledge_Reward(pledgeReward);
        return new ResponseEntity<>(savePledge_Reward, HttpStatus.CREATED);
    }

    /**
     * GET REST API (with id parameter).
     * @param pledgeRewardId The Pledge Reward ID to be searched.
     * @return The response to the operation.
     */
    @GetMapping("{id}")
    public ResponseEntity<Pledge_Reward> getPledge_RewardById(@PathVariable("id") Long pledgeRewardId) {
        Pledge_Reward pledgeReward = pledgeRewardService.getPledge_RewardById(pledgeRewardId);
        return new ResponseEntity<>(pledgeReward, HttpStatus.OK);
    }

    /**
     * GET REST API (with no parameters).
     * @return The response to the operation.
     */
    @GetMapping
    public ResponseEntity<List<Pledge_Reward>> getAllPledge_Rewards() {
        List<Pledge_Reward> pledgeRewards = pledgeRewardService.getAllPledge_Rewards();
        return new ResponseEntity<>(pledgeRewards, HttpStatus.OK);
    }

    /**
     * PUT REST API.
     * @param pledgeRewardId The pledge reward id to be searched.
     * @param pledgeReward The new pledge reward data to be modified.
     * @return The response to the operation.
     */
    @PutMapping("{id}")
    public ResponseEntity<Pledge_Reward> updatePledge_Reward(@PathVariable("id") Long pledgeRewardId,
                                                             @RequestBody Pledge_Reward pledgeReward) {
        pledgeReward.setId(pledgeRewardId);
        Pledge_Reward updatedPledge_Reward = pledgeRewardService.updatePledge_Reward(pledgeReward);
        return new ResponseEntity<>(updatedPledge_Reward, HttpStatus.OK);
    }

    /**
     * DELETE REST API.
     * @param pledgeRewardId The pledge reward id to be searched.
     * @return The response to the operation.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePledge_Reward(@PathVariable("id") Long pledgeRewardId) {
        pledgeRewardService.deletePledge_Reward(pledgeRewardId);
        return new ResponseEntity<>("Pledge Reward successfully deleted!", HttpStatus.OK);
    }
}
