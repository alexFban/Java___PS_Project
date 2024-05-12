package crud.operations.repository;

import crud.operations.entity.User_Project;

import java.util.List;
import java.util.Optional;

/**
 * An interface that defines the methods for performing CRUD operations on the User_Project.
 */
public interface User_ProjectRepository {
    public User_Project save(User_Project userProject);

    public Optional<User_Project> findById(Long userProjectId);

    public List<User_Project> findAll();

    public void deleteById(Long userProjectId);
}
