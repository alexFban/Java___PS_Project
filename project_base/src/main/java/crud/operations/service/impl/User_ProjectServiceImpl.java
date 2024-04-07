package crud.operations.service.impl;

import crud.operations.entity.User_Project;
import crud.operations.repository.UserRepository;
import crud.operations.repository.User_ProjectRepository;
import crud.operations.service.UserService;
import crud.operations.service.User_ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A class that implements {@link User_ProjectService} interface methods.
 */
@Service
@AllArgsConstructor
public class User_ProjectServiceImpl implements User_ProjectService {

    /**
     * Instance of {@link User_ProjectRepository} class
     */
    private User_ProjectRepository userProjectRepository;

    /**
     * Adds new User_Project to the DataBase. Equivalent to the POST operation.
     * @param userProject The user project data we want to be saved.
     * @return The new repository, with the saved User_Project.
     */
    @Override
    public User_Project createUser_Project(User_Project userProject) { return userProjectRepository.save(userProject); }

    /**
     * Searches for a User_Project with the given id. Equivalent to the GET operation.
     * @param userProjectId The user project id we want to be searched.
     * @return The User_Project with the searched id (if it exists).
     */
    @Override
    public User_Project getUser_ProjectById(Long userProjectId) {
        Optional<User_Project> optionalUserProject = userProjectRepository.findById(userProjectId);
        return optionalUserProject.get();
    }

    /**
     * Gets all user projects that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All User_Projects.
     */
    @Override
    public List<User_Project> getAllUser_Projects() { return userProjectRepository.findAll(); }

    /**
     * Deletes User_Project with the given id. Equivalent to the DELETE operation.
     * @param userProjectId The user project id we want to be searched.
     */
    @Override
    public void deleteUser_Project(Long userProjectId) { userProjectRepository.deleteById(userProjectId); }
}
