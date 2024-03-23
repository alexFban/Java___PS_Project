package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(Long projectId);
    List<Project> getAllProjects();
    Project updateProject(Project project);
    void deleteProject(Long projectId);
}
