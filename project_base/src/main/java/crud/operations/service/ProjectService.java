package crud.operations.service;

import crud.operations.entity.Project;
import crud.operations.entity.User;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for Project.
 */
public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(Long projectId);
    List<Project> getAllProjects();
    public List<User> getProjectUsers(Long projectId);
    Project updateProject(Project project);
    void deleteProject(Long projectId);
}
