package learn.employee.employees;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import learn.employee.employerprofile.Profile;
import learn.employee.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(
            name = "teamId"
    )
    @JsonBackReference
    private Team team;
    @OneToOne(
            mappedBy ="employee"
    )
    @JsonManagedReference
    private Profile profile;


}
