package learn.employee.employerprofile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import learn.employee.employees.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String bio;
    @OneToOne
    @JoinColumn(
            name = "employeeId"
    )
    @JsonBackReference
    private Employee employee;

}
