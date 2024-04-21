package com.example.restservice.service.impl;

import crud.operations.entity.Project;
import crud.operations.entity.Social_Goal;
import crud.operations.entity.Social_Reward;
import crud.operations.repository.Social_GoalRepository;
import crud.operations.service.impl.Social_GoalServiceImpl;
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

public class Social_GoalServiceImplTests {
    @Mock
    Social_GoalRepository socialGoalRepositoryMock;

    private Social_GoalServiceImpl socialGoalService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        socialGoalService = new Social_GoalServiceImpl(socialGoalRepositoryMock);
    }

    @Test
    public void createSocialGoalTest() {
        Social_Goal socialGoal = new Social_Goal(1L, new Project(), new Social_Reward(), 0, 10, "description");

        Mockito.when(socialGoalRepositoryMock.save(socialGoal)).thenReturn(socialGoal);

        Social_Goal userResult = socialGoalService.createSocial_Goal(socialGoal);
        Mockito.verify(socialGoalRepositoryMock).save(socialGoal);
        assertEquals(userResult, socialGoal);
    }

    @Test
    public void getSocialGoalByIdTest() {
        Social_Goal socialGoal = new Social_Goal(1L, new Project(), new Social_Reward(), 0, 10, "description");

        Mockito.when(socialGoalRepositoryMock.findById(socialGoal.getId())).thenReturn(Optional.of(socialGoal));

        Social_Goal userResult = socialGoalService.getSocial_GoalById(socialGoal.getId());
        Mockito.verify(socialGoalRepositoryMock).findById(socialGoal.getId());
        assertEquals(userResult, socialGoal);
    }

    @Test
    public void getAllSocialGoalsTest() {
        Social_Goal socialGoal = new Social_Goal(1L, new Project(), new Social_Reward(), 0, 10, "description");
        Social_Goal socialGoal2 = new Social_Goal(2L, new Project(), new Social_Reward(), 0, 10, "description");
        Social_Goal socialGoal3 = new Social_Goal(3L, new Project(), new Social_Reward(), 0, 10, "description");
        List<Social_Goal> users = Arrays.asList(socialGoal, socialGoal2, socialGoal3);

        Mockito.when(socialGoalRepositoryMock.findAll()).thenReturn(users);

        List<Social_Goal> usersResult = socialGoalService.getAllSocial_Goals();
        Mockito.verify(socialGoalRepositoryMock).findAll();
        assertEquals(usersResult, users);
    }

    @Test
    public void updateSocialGoalTest() {
        Social_Goal socialGoal = new Social_Goal(1L, new Project(), new Social_Reward(), 0, 10, "description");
        Social_Goal modifiedSocialGoal = new Social_Goal(1L, new Project(), new Social_Reward(), 0, 20, "description");

        Mockito.when(socialGoalRepositoryMock.findById(socialGoal.getId())).thenReturn(Optional.of(socialGoal));
        Mockito.when(socialGoalRepositoryMock.save(socialGoal)).thenReturn(modifiedSocialGoal);

        Social_Goal modifiedSocialGoalResult = socialGoalService.updateSocial_Goal(socialGoal);
        Mockito.verify(socialGoalRepositoryMock).save(socialGoal);
        assertEquals(modifiedSocialGoalResult, modifiedSocialGoal);
    }

    @Test
    public void deleteSocialGoalTest() {
        Social_Goal socialGoal = new Social_Goal(1L, new Project(), new Social_Reward(), 0, 10, "description");

        Mockito.doNothing().when(socialGoalRepositoryMock).deleteById(socialGoal.getId());

        socialGoalService.deleteSocial_Goal(socialGoal.getId());
        Mockito.verify(socialGoalRepositoryMock).deleteById(socialGoal.getId());
        assertNull(null);
    }
}
