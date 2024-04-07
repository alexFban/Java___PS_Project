package crud.operations.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing challenges for the pledged users that grant a {@link Social_Reward} when completed
 * @author Ban Alex
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "social_goals")
public class Social_Goal {

    /**
     * @hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @hidden
     */
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    /**
     * @hidden
     */
    @JsonIgnore
    @OneToOne(mappedBy = "socialGoal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Social_Reward socialReward;

    /**
     * Number representing the percentage of completion of the goal
     */
    @Column(nullable = false)
    private int number_achieved = 0;

    /**
     * Number representing the total amount for the goal to be completed
     */
    @Column(nullable = false)
    private int number_to_achieve;

    /**
     * Description detailing the actions necessary to be taken by the users in order to complete the goal
     */
    @Column(nullable = false)
    private String description;
}
