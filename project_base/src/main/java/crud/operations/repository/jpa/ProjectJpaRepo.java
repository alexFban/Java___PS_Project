package crud.operations.repository.jpa;

import crud.operations.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJpaRepo extends JpaRepository<Project, Long> {
}
