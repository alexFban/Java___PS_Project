package crud.operations.service.impl;

import crud.operations.entity.Project;
import crud.operations.entity.User;
import crud.operations.entity.User_Project;
import crud.operations.service.UserService;
import lombok.AllArgsConstructor;
import crud.operations.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A class that implements {@link UserService} interface methods.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    /**
     * Instance of {@link UserRepository} class
     */
    private UserRepository userRepository;

    /**
     * Adds new User to the DataBase. Equivalent to the POST operation.
     * @param user The user data we want to be saved.
     * @return The new repository, with the saved User.
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Searches for a User with the given id. Equivalent to the GET operation.
     * @param userId The user id we want to be searched.
     * @return The User with the searched id (if it exists).
     */
    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    /**
     * Gets all users that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Users.
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Gets all project that the user is affiliated with.
     * @param userId The user id we want the projects from.
     * @return All Projects.
     */
    @Override
    public List<Project> getUserProjects(Long userId) {
        User user = getUserById(userId);
        List<Project> projects = new ArrayList<>();
        for (User_Project userProject : user.getUser_projects()) {
            projects.add(userProject.getProject());
        }
        return projects;
    }

    /**
     * Adds/modifies data of an existing User. Equivalent to the PUT operation.
     * @param user The user data we want to be modified.
     * @return The modified user data.
     */
    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setUsername(user.getUsername() == null ?
                                existingUser.getUsername() : user.getUsername());
        existingUser.setPassword(user.getPassword() == null ?
                                existingUser.getPassword() : user.getPassword());
        existingUser.setFirstName(user.getFirstName() == null ?
                                existingUser.getFirstName() : user.getFirstName());
        existingUser.setLastName(user.getLastName() ==null ?
                                existingUser.getLastName() : user.getLastName());
        existingUser.setEmail(user.getEmail() == null ?
                            existingUser.getEmail() : user.getEmail());
        existingUser.setPhone_number(user.getPhone_number() == -1 ?
                                    existingUser.getPhone_number() : user.getPhone_number());
        existingUser.setType(user.getType() == null ?
                            existingUser.getType() : user.getType());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    /**
     * Deletes User with the given id. Equivalent to the DELETE operation.
     * @param userId The user id we want to be searched.
     */
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}