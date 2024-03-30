package crud.operations.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(nullable = false)
    private String description;
}
