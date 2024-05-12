package crud.operations.repository.impl;

import crud.operations.entity.User_Project;
import crud.operations.repository.jpa.User_ProjectJpaRepo;
import crud.operations.repository.User_ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class User_ProjectRepositoryImpl implements User_ProjectRepository {
    User_ProjectJpaRepo jpaRepository;

    @Override
    public User_Project save(User_Project userProject) {
        return jpaRepository.save(userProject);
    }

    @Override
    public Optional<User_Project> findById(Long userProjectId) {
        return jpaRepository.findById(userProjectId);
    }

    @Override
    public List<User_Project> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long userProjectId) {
        jpaRepository.deleteById(userProjectId);
    }
}
