package learn.employee.team;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import learn.employee.employees.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "team"
    )
    @JsonManagedReference
    private List<Employee> employeeList;
}
