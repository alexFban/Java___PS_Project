package crud.operations.service;

import crud.operations.entity.Project;
import crud.operations.entity.User;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for Project.
 */
public interface ProjectService {
    /**
     * Adds new Project to the DataBase. Equivalent to the POST operation.
     * @param project The user data we want to be saved.
     * @return The new repository, with the saved Project.
     */
    Project createProject(Project project);
    /**
     * Searches for a Project with the given id. Equivalent to the GET operation.
     * @param projectId The project id we want to be searched.
     * @return The Project with the searched id (if it exists).
     */
    Project getProjectById(Long projectId);
    /**
     * Gets all projects that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Projects.
     */
    List<Project> getAllProjects();
    /**
     * Gets all users that the project is affiliated with.
     * @param projectId The project id we want the users from.
     * @return All Users.
     */
    public List<User> getProjectUsers(Long projectId);
    /**
     * Adds/modifies data of an existing Project. Equivalent to the PUT operation.
     * @param project The project data we want to be modified.
     * @return The modified project data.
     */
    Project updateProject(Project project);
    /**
     * Deletes Project with the given id. Equivalent to the DELETE operation.
     * @param projectId The project id we want to be searched.
     */
    void deleteProject(Long projectId);
}
