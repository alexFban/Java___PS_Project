package crud.operations.repository.jpa;

import crud.operations.entity.User_Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_ProjectJpaRepo extends JpaRepository<User_Project, Long> {
}
