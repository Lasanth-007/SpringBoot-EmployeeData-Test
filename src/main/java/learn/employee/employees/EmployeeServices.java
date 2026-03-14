package learn.employee.employees;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
}
