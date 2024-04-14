package crud.operations.service;

import crud.operations.entity.Project;
import crud.operations.entity.User;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for User.
 */
public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    public List<Project> getUserProjects(Long userId);

    User updateUser(User user);

    void deleteUser(Long userId);
}