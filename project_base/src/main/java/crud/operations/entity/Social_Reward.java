package crud.operations.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing the rewards that pledged users will get for completing a {@link Social_Goal}
 * @author Ban Alex
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "social_rewards")
public class Social_Reward {

    /**
     * @hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @hidden
     */
    @OneToOne
    @JoinColumn(name = "social_goal_id", referencedColumnName = "id")
    private Social_Goal socialGoal;

    /**
     * Description detailing the reward that will be granted to the pledged users after completing the assigned {@link Social_Goal}
     */
    @Column(nullable = false)
    private String description;
}
