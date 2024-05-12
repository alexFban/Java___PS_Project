package crud.operations.repository;

import crud.operations.entity.Project;

import java.util.List;
import java.util.Optional;

/**
 * An interface that defines the methods for performing CRUD operations on the Project.
 */
public interface ProjectRepository {
    public Project save(Project project);

    public Optional<Project> findById(Long projectId);

    public List<Project> findAll();

    public void deleteById(Long projectId);
}
