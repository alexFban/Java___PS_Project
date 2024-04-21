package com.example.restservice.service.impl;

import crud.operations.entity.Project;
import crud.operations.entity.User;
import crud.operations.entity.User_Project;
import crud.operations.repository.User_ProjectRepository;
import crud.operations.service.impl.User_ProjectServiceImpl;
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

public class User_ProjectServiceImplTests {
    @Mock
    User_ProjectRepository userProjectRepositoryMock;

    private User_ProjectServiceImpl userProjectService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userProjectService = new User_ProjectServiceImpl(userProjectRepositoryMock);
    }

    @Test
    public void createUser_ProjectTest() {
        User_Project userProject = new User_Project(1L,new User(),new Project(),3);

        Mockito.when(userProjectRepositoryMock.save(userProject)).thenReturn(userProject);

        User_Project userResult = userProjectService.createUser_Project(userProject);
        Mockito.verify(userProjectRepositoryMock).save(userProject);
        assertEquals(userResult, userProject);
    }

    @Test
    public void getUser_ProjectByIdTest() {
        User_Project userProject = new User_Project(1L,new User(),new Project(),3);

        Mockito.when(userProjectRepositoryMock.findById(userProject.getId())).thenReturn(Optional.of(userProject));

        User_Project userProjectResult = userProjectService.getUser_ProjectById(userProject.getId());
        Mockito.verify(userProjectRepositoryMock).findById(userProject.getId());
        assertEquals(userProjectResult, userProject);
    }

    @Test
    public void getAllUser_ProjectsTest() {
        User_Project userProject = new User_Project(1L,new User(),new Project(),3);
        User_Project userProject2 = new User_Project(2L,new User(),new Project(),3);
        User_Project userProject3 = new User_Project(13L,new User(),new Project(),3);
        List<User_Project> users = Arrays.asList(userProject, userProject2, userProject3);

        Mockito.when(userProjectRepositoryMock.findAll()).thenReturn(users);

        List<User_Project> usersResult = userProjectService.getAllUser_Projects();
        Mockito.verify(userProjectRepositoryMock).findAll();
        assertEquals(usersResult, users);
    }

    @Test
    public void deleteUser_ProjectTest() {
        User_Project userProject = new User_Project(1L,new User(),new Project(),3);

        Mockito.doNothing().when(userProjectRepositoryMock).deleteById(userProject.getId());

        userProjectService.deleteUser_Project(userProject.getId());
        Mockito.verify(userProjectRepositoryMock).deleteById(userProject.getId());
        assertNull(null);
    }
}
