package crud.operations.controller;

import crud.operations.entity.Pledge_Reward;
import crud.operations.service.Pledge_RewardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/pledge_rewards")
public class Pledge_RewardController {
    private Pledge_RewardService pledgeRewardService;
    @PostMapping
    public ResponseEntity<Pledge_Reward> createPledge_Reward(@RequestBody Pledge_Reward pledgeReward) {
        Pledge_Reward savePledge_Reward = pledgeRewardService.createPledge_Reward(pledgeReward);
        return new ResponseEntity<>(savePledge_Reward, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Pledge_Reward> getPledge_RewardById(@PathVariable("id") Long pledgeRewardId) {
        Pledge_Reward pledgeReward = pledgeRewardService.getPledge_RewardById(pledgeRewardId);
        return new ResponseEntity<>(pledgeReward, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Pledge_Reward>> getAllPledge_Rewards() {
        List<Pledge_Reward> pledgeRewards = pledgeRewardService.getAllPledge_Rewards();
        return new ResponseEntity<>(pledgeRewards, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Pledge_Reward> updatePledge_Reward(@PathVariable("id") Long pledgeRewardId,
                                                             @RequestBody Pledge_Reward pledgeReward) {
        pledgeReward.setId(pledgeRewardId);
        Pledge_Reward updatedPledge_Reward = pledgeRewardService.updatePledge_Reward(pledgeReward);
        return new ResponseEntity<>(updatedPledge_Reward, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePledge_Reward(@PathVariable("id") Long pledgeRewardId) {
        pledgeRewardService.deletePledge_Reward(pledgeRewardId);
        return new ResponseEntity<>("Pledge Reward successfully deleted!", HttpStatus.OK);
    }
}
