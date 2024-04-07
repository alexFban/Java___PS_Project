package crud.operations.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Project {
    /**
     * @hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * @hidden
     */
    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User_Project> user_projects = new ArrayList<>();
    /**
     * @hidden
     */
    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pledge_Reward> pledge_rewards = new ArrayList<>();
    /**
     * @hidden
     */
    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Social_Goal> social_goals = new ArrayList<>();

    /**
     * Amount of money to have been raised at a specific moment.
     */
    @Column(nullable = false)
    private String name;
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
    public void update(Object update_info) {
        for (User_Project userProject : this.getUser_projects()) {
            userProject.update(update_info);
        }
    }
}
