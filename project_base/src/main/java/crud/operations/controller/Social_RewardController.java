package crud.operations.controller;

import crud.operations.entity.Social_Reward;
import crud.operations.service.Social_RewardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/social_rewards")
public class Social_RewardController {
    private Social_RewardService socialRewardService;
    @PostMapping
    public ResponseEntity<Social_Reward> createSocial_Reward(@RequestBody Social_Reward socialReward) {
        Social_Reward saveSocial_Reward = socialRewardService.createSocial_Reward(socialReward);
        return new ResponseEntity<>(saveSocial_Reward, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Social_Reward> getSocial_RewardById(@PathVariable("id") Long socialRewardId) {
        Social_Reward socialReward = socialRewardService.getSocial_RewardById(socialRewardId);
        return new ResponseEntity<>(socialReward, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Social_Reward>> getAllSocial_Rewards() {
        List<Social_Reward> socialRewards = socialRewardService.getAllSocial_Rewards();
        return new ResponseEntity<>(socialRewards, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Social_Reward> updateSocial_Reward(@PathVariable("id") Long socialRewardId,
                                                         @RequestBody Social_Reward socialReward) {
        socialReward.setId(socialRewardId);
        Social_Reward updatedSocial_Reward = socialRewardService.updateSocial_Reward(socialReward);
        return new ResponseEntity<>(updatedSocial_Reward, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSocial_Reward(@PathVariable("id") Long socialRewardId) {
        socialRewardService.deleteSocial_Reward(socialRewardId);
        return new ResponseEntity<>("Social Reward successfully deleted!", HttpStatus.OK);
    }
}
