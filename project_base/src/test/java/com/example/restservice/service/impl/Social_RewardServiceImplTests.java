package com.example.restservice.service.impl;

import crud.operations.entity.Social_Goal;
import crud.operations.entity.Social_Reward;
import crud.operations.repository.Social_RewardRepository;
import crud.operations.service.impl.Social_RewardServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Social_RewardServiceImplTests {
    @Mock
    Social_RewardRepository socialRewardRepositoryMock;

    private Social_RewardServiceImpl socialRewardService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        socialRewardService = new Social_RewardServiceImpl(socialRewardRepositoryMock);
    }

    @Test
    public void createSocialRewardTest() {
        Social_Reward socialReward = new Social_Reward(1L, new Social_Goal(), "description");

        Mockito.when(socialRewardRepositoryMock.save(socialReward)).thenReturn(socialReward);

        Social_Reward userResult = socialRewardService.createSocial_Reward(socialReward);
        Mockito.verify(socialRewardRepositoryMock).save(socialReward);
        assertEquals(userResult, socialReward);
    }

    @Test
    public void getSocialRewardByIdTest() {
        Social_Reward socialReward = new Social_Reward(1L, new Social_Goal(), "description");

        Mockito.when(socialRewardRepositoryMock.findById(socialReward.getId())).thenReturn(Optional.of(socialReward));

        Social_Reward userResult = socialRewardService.getSocial_RewardById(socialReward.getId());
        Mockito.verify(socialRewardRepositoryMock).findById(socialReward.getId());
        assertEquals(userResult, socialReward);
    }

    @Test
    public void getAllSocialRewardsTest() {
        Social_Reward socialReward = new Social_Reward(1L, new Social_Goal(), "description");
        Social_Reward socialReward2 = new Social_Reward(2L, new Social_Goal(), "description");
        Social_Reward socialReward3 = new Social_Reward(13L, new Social_Goal(), "description");
        List<Social_Reward> users = Arrays.asList(socialReward, socialReward2, socialReward3);

        Mockito.when(socialRewardRepositoryMock.findAll()).thenReturn(users);

        List<Social_Reward> usersResult = socialRewardService.getAllSocial_Rewards();
        Mockito.verify(socialRewardRepositoryMock).findAll();
        assertEquals(usersResult, users);
    }

    @Test
    public void updateSocialRewardTest() {
        Social_Reward socialReward = new Social_Reward(1L, new Social_Goal(), "description");
        Social_Reward modifiedSocialReward = new Social_Reward(1L, new Social_Goal(), "modified_description");

        Mockito.when(socialRewardRepositoryMock.findById(socialReward.getId())).thenReturn(Optional.of(socialReward));
        Mockito.when(socialRewardRepositoryMock.save(socialReward)).thenReturn(modifiedSocialReward);

        Social_Reward modifiedSocialRewardResult = socialRewardService.updateSocial_Reward(socialReward);
        Mockito.verify(socialRewardRepositoryMock).save(socialReward);
        assertEquals(modifiedSocialRewardResult, modifiedSocialReward);
    }

    @Test
    public void deleteSocialRewardTest() {
        Social_Reward socialReward = new Social_Reward(1L, new Social_Goal(), "description");

        Mockito.doNothing().when(socialRewardRepositoryMock).deleteById(socialReward.getId());

        socialRewardService.deleteSocial_Reward(socialReward.getId());
        Mockito.verify(socialRewardRepositoryMock).deleteById(socialReward.getId());
        assertNull(null);
    }
}
