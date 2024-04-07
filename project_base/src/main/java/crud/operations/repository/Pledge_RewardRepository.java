package crud.operations.repository;

import crud.operations.entity.Pledge_Reward;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * An interface that defines the methods for performing CRUD operations on the Pledge_Reward.
 */
public interface Pledge_RewardRepository extends JpaRepository<Pledge_Reward, Long> {
}
