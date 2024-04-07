package crud.operations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing the rewards that pledged users will get after the funding period of the {@link Project} ends
 * @author Ban Alex
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pledge_rewards")
public class Pledge_Reward {

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
     * Name representing the item(s) that the pledged users will receive upon project completion
     */
    @Column(nullable = false)
    private String item;

    /**
     * In detail description of the items that will be received
     */
    @Column(nullable = false)
    private String description;

    /**
     * Number representing the minimum tier a user has to be part of in order to receive the items
     */
    @Column(nullable = false)
    private int minimum_pledge_level;
}
