package com.example.restservice.service.impl;

import crud.operations.entity.Project;
import crud.operations.repository.ProjectRepository;
import crud.operations.service.impl.ProjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProjectServiceImplTests {
    @Mock
    ProjectRepository projectRepositoryMock;

    private ProjectServiceImpl projectService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        projectService = new ProjectServiceImpl(projectRepositoryMock);
    }

    @Test
    public void createProjectTest() {
        Project project = new Project(1L,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"project",0,10,"description");

        Mockito.when(projectRepositoryMock.save(project)).thenReturn(project);

        Project userResult = projectService.createProject(project);
        Mockito.verify(projectRepositoryMock).save(project);
        assertEquals(userResult, project);
    }

    @Test
    public void getProjectByIdTest() {
        Project project = new Project(1L,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"project",0,10,"description");

        Mockito.when(projectRepositoryMock.findById(project.getId())).thenReturn(Optional.of(project));

        Project userResult = projectService.getProjectById(project.getId());
        Mockito.verify(projectRepositoryMock).findById(project.getId());
        assertEquals(userResult, project);
    }

    @Test
    public void getAllProjectsTest() {
        Project project = new Project(1L,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"project",0,10,"description");
        Project project2 = new Project(2L,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"project",0,10,"description");
        Project project3 = new Project(3L,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"project",0,10,"description");
        List<Project> users = Arrays.asList(project, project2, project3);

        Mockito.when(projectRepositoryMock.findAll()).thenReturn(users);

        List<Project> usersResult = projectService.getAllProjects();
        Mockito.verify(projectRepositoryMock).findAll();
        assertEquals(usersResult, users);
    }

    @Test
    public void updateProjectTest() {
        Project project = new Project(1L,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"project",0,10,"description");
        Project modifiedProject = new Project(1L,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"modified_project",0,10,"description");

        Mockito.when(projectRepositoryMock.findById(project.getId())).thenReturn(Optional.of(project));
        Mockito.when(projectRepositoryMock.save(project)).thenReturn(modifiedProject);

        Project modifiedProjectResult = projectService.updateProject(project);
        Mockito.verify(projectRepositoryMock).save(project);
        assertEquals(modifiedProjectResult, modifiedProject);
    }

    @Test
    public void deleteProjectTest() {
        Project project = new Project(1L,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"project",0,10,"description");

        Mockito.doNothing().when(projectRepositoryMock).deleteById(project.getId());

        projectService.deleteProject(project.getId());
        Mockito.verify(projectRepositoryMock).deleteById(project.getId());
        assertNull(null);
    }
}
