package crud.operations.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing connections between users and projects
 * @author Ban Alex
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_projects")
public class User_Project {

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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     * @hidden
     */
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    /**
     * Number representing a tier that the {@link User} has been assigned to, depending on the money pledged to the {@link Project}
     */
    @Column(nullable = false)
    private int pledge_level;

    /**
     * Method called when a project is updated, containing the actions to be taken
     * @param updateInfo An object containing the essential update data
     */
    public void update(Object updateInfo) {
        this.user.update(updateInfo);
    }
}
