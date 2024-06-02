package crud.operations.service;

import crud.operations.entity.Project;
import crud.operations.entity.User;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for User.
 */
public interface UserService {
    /**
     * Adds new User to the DataBase. Equivalent to the POST operation.
     * @param user The user data we want to be saved.
     * @return The new repository, with the saved User.
     */
    User createUser(User user);
    /**
     * Searches for a User with the given id. Equivalent to the GET operation.
     * @param userId The user id we want to be searched.
     * @return The User with the searched id (if it exists).
     */
    User getUserById(Long userId);
    /**
     * Gets all users that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Users.
     */
    List<User> getAllUsers();
    User getUserByUsername(String username);
    /**
     * Gets all project that the user is affiliated with.
     * @param userId The user id we want the projects from.
     * @return All Projects.
     */
    public List<Project> getUserProjects(Long userId);
    /**
     * Adds/modifies data of an existing User. Equivalent to the PUT operation.
     * @param user The user data we want to be modified.
     * @return The modified user data.
     */
    User updateUser(User user);
    /**
     * Deletes User with the given id. Equivalent to the DELETE operation.
     * @param userId The user id we want to be searched.
     */
    void deleteUser(Long userId);
}