package crud.operations.service;

import crud.operations.entity.User_Project;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for User_Project.
 */
public interface User_ProjectService {
    /**
     * Adds new User_Project to the DataBase. Equivalent to the POST operation.
     * @param userProject The user project data we want to be saved.
     * @return The new repository, with the saved User_Project.
     */
    User_Project createUser_Project(User_Project userProject);
    /**
     * Searches for a User_Project with the given id. Equivalent to the GET operation.
     * @param userProjectId The user project id we want to be searched.
     * @return The User_Project with the searched id (if it exists).
     */
    User_Project getUser_ProjectById(Long userProjectId);
    /**
     * Gets all user projects that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All User_Projects.
     */
    List<User_Project> getAllUser_Projects();
    /**
     * Deletes User_Project with the given id. Equivalent to the DELETE operation.
     * @param userProjectId The user project id we want to be searched.
     */
    void deleteUser_Project(Long userProjectId);
}
