package oatjin.ems_java_backend.service.Implement;

import oatjin.ems_java_backend.dto.ResponseDTO;
import oatjin.ems_java_backend.entity.Employee;
import oatjin.ems_java_backend.repository.EmployeeRepository;
import oatjin.ems_java_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<ResponseDTO<Employee>> addEmployee(Employee employee) {
        try {
            // Attempt to save the employee
            Employee savedEmployee = employeeRepository.save(employee);
            ResponseDTO<Employee> responseDTO = new ResponseDTO<>(true, "Add employee success", savedEmployee);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            ResponseDTO<Employee> errorResponse = new ResponseDTO<>(false, "Failed to add employee: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
