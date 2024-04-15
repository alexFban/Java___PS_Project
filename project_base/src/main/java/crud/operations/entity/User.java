package crud.operations.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import crud.operations.service.impl.UserServiceImpl;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class of the project, representing the users that will be using the app.
 * @author Ban Alex
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Observer{

    /**
     * @hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @hidden
     */
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User_Project> user_projects = new ArrayList<>();

    /**
     * Name that the user wishes to go by.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * String of characters representing the login key.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Real first name of the user.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * Real last name of the user.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * Email address used to communicate with the user.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Phone number used as a backup for logging in (can be null).
     */
    @Column(nullable = true)
    private int phone_number = -1;

    /**
     * Identifier for user permissions.
     */
    @Column(nullable = false)
    private String type;

    /**
     * Method called when a project is updated, containing the actions to be taken
     * @param updateInfo An object containing the essential update data
     */
    public void update(Object updateInfo) {
        System.out.println("Notification (" + this.firstName +  "): " + (String) updateInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if(!(o instanceof User)) {
            return false;
        }

        User user = (User) o;
        return user.id.equals(this.id);
    }
}