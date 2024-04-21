package com.example.restservice.service.impl;

import crud.operations.entity.Pledge_Reward;
import crud.operations.entity.Project;
import crud.operations.repository.Pledge_RewardRepository;
import crud.operations.service.impl.Pledge_RewardServiceImpl;
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

public class Pledge_RewardServiceImplTests {
    @Mock
    Pledge_RewardRepository pledgeRewardRepositoryMock;

    private Pledge_RewardServiceImpl pledgeRewardService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        pledgeRewardService = new Pledge_RewardServiceImpl(pledgeRewardRepositoryMock);
    }

    @Test
    public void createPledgeRewardTest() {
        Pledge_Reward pledgeReward = new Pledge_Reward(1L, new Project(), "item", "description", 2);

        Mockito.when(pledgeRewardRepositoryMock.save(pledgeReward)).thenReturn(pledgeReward);

        Pledge_Reward userResult = pledgeRewardService.createPledge_Reward(pledgeReward);
        Mockito.verify(pledgeRewardRepositoryMock).save(pledgeReward);
        assertEquals(userResult, pledgeReward);
    }

    @Test
    public void getPledgeRewardByIdTest() {
        Pledge_Reward pledgeReward = new Pledge_Reward(1L, new Project(), "item", "description", 2);

        Mockito.when(pledgeRewardRepositoryMock.findById(pledgeReward.getId())).thenReturn(Optional.of(pledgeReward));

        Pledge_Reward userResult = pledgeRewardService.getPledge_RewardById(pledgeReward.getId());
        Mockito.verify(pledgeRewardRepositoryMock).findById(pledgeReward.getId());
        assertEquals(userResult, pledgeReward);
    }

    @Test
    public void getAllPledgeRewardsTest() {
        Pledge_Reward pledgeReward = new Pledge_Reward(1L, new Project(), "item", "description", 2);
        Pledge_Reward pledgeReward2 = new Pledge_Reward(2L, new Project(), "item", "description", 2);
        Pledge_Reward pledgeReward3 = new Pledge_Reward(3L, new Project(), "item", "description", 2);
        List<Pledge_Reward> users = Arrays.asList(pledgeReward, pledgeReward2, pledgeReward3);

        Mockito.when(pledgeRewardRepositoryMock.findAll()).thenReturn(users);

        List<Pledge_Reward> usersResult = pledgeRewardService.getAllPledge_Rewards();
        Mockito.verify(pledgeRewardRepositoryMock).findAll();
        assertEquals(usersResult, users);
    }

    @Test
    public void updatePledgeRewardTest() {
        Pledge_Reward pledgeReward = new Pledge_Reward(1L, new Project(), "item", "description", 2);
        Pledge_Reward modifiedPledgeReward = new Pledge_Reward(1L, new Project(), "modified_item", "description", 2);

        Mockito.when(pledgeRewardRepositoryMock.findById(pledgeReward.getId())).thenReturn(Optional.of(pledgeReward));
        Mockito.when(pledgeRewardRepositoryMock.save(pledgeReward)).thenReturn(modifiedPledgeReward);

        Pledge_Reward modifiedPledgeRewardResult = pledgeRewardService.updatePledge_Reward(pledgeReward);
        Mockito.verify(pledgeRewardRepositoryMock).save(pledgeReward);
        assertEquals(modifiedPledgeRewardResult, modifiedPledgeReward);
    }

    @Test
    public void deletePledgeRewardTest() {
        Pledge_Reward pledgeReward = new Pledge_Reward(1L, new Project(), "item", "description", 2);

        Mockito.doNothing().when(pledgeRewardRepositoryMock).deleteById(pledgeReward.getId());

        pledgeRewardService.deletePledge_Reward(pledgeReward.getId());
        Mockito.verify(pledgeRewardRepositoryMock).deleteById(pledgeReward.getId());
        assertNull(null);
    }
}
