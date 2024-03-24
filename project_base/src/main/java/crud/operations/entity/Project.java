package crud.operations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Main class of the project, representing the projects that will be using the app.
 * @author Ban Alex
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    /**
     * @hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * Amount of money to have been raised at a specific moment.
     */
    @Column(nullable = false)
    private int money_raised;
    /**
     * Amount of money that is to be achieved.
     */
    @Column(nullable = false)
    private int funding_goal;
    /**
     * Brief description of what is the project about.
     */
    @Column(nullable = false)
    private String description;
}
