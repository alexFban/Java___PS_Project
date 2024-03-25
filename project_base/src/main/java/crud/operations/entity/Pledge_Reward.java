package crud.operations.entity;

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
    @Column(nullable = false)
    private String item;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int minimum_pledge_level;
}
