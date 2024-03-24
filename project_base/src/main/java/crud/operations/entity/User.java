package crud.operations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class User {
    /**
     * @hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
}