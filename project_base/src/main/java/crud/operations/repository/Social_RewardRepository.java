package crud.operations.repository;

import crud.operations.entity.Social_Reward;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * An interface that defines the methods for performing CRUD operations on the Social_Reward.
 */
public interface Social_RewardRepository extends JpaRepository<Social_Reward, Long> {
}
