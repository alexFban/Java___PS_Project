package crud.operations.repository.impl;

import crud.operations.entity.Project;
import crud.operations.repository.ProjectRepository;
import crud.operations.repository.jpa.ProjectJpaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepository {

    ProjectJpaRepo jpaRepository;

    @Override
    public Project save(Project project) {
        return jpaRepository.save(project);
    }

    @Override
    public Optional<Project> findById(Long projectId) {
        return jpaRepository.findById(projectId);
    }

    @Override
    public List<Project> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long projectId) {
        jpaRepository.deleteById(projectId);
    }
}
