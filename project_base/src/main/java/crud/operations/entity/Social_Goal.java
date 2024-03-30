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
    @Column(nullable = false)
    private int number_achieved = 0;
    @Column(nullable = false)
    private int number_to_achieve;
    @Column(nullable = false)
    private String description;
}
