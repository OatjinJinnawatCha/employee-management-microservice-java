package oatjin.ems_java_backend.service.Implement;

import oatjin.ems_java_backend.dto.ResponseDTO;
import oatjin.ems_java_backend.entity.Employee;
import oatjin.ems_java_backend.repository.EmployeeRepository;
import oatjin.ems_java_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<ResponseDTO<Employee>> addEmployee(Employee employee) {
        try {
            employee.setDateAdded(LocalDateTime.now());
            employee.setEmployeeCode(generateEmployeeCode());
            Employee savedEmployee = employeeRepository.save(employee);
            ResponseDTO<Employee> responseDTO = new ResponseDTO<>(true, "Add employee success", savedEmployee);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO<Employee> errorResponse = new ResponseDTO<>(false, "Failed to add employee: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @Override
    public ResponseDTO<Employee> updateEmployeeByEmployeeCode(String employeeCode, Employee newEmployee) {
        Timestamp timeNow = Timestamp.valueOf(LocalDateTime.now());
        Employee existingEmployee = employeeRepository.findByEmployeeCode(employeeCode);
        existingEmployee.setFirstName(newEmployee.getFirstName());
        existingEmployee.setLastName(newEmployee.getLastName());
        existingEmployee.setNickName(newEmployee.getNickName());
        existingEmployee.setEmail(newEmployee.getEmail());
        existingEmployee.setDepartment(newEmployee.getDepartment());
        existingEmployee.setJobTitle(newEmployee.getJobTitle());
        existingEmployee.setUpdatedDate(timeNow);

        Employee savedEmployee = employeeRepository.save(existingEmployee);
        return new ResponseDTO<>(true, "Update employee success", savedEmployee);
    }

    @Override
    public ResponseDTO<Employee> deleteEmployeeByEmployeeCode(String employeeCode) {
        Employee employee = employeeRepository.findByEmployeeCode(employeeCode);
        employeeRepository.delete(employee);
        return new ResponseDTO<>(true, "Delete employee success", employee);
    }

    // function for generate employee code
    public String generateEmployeeCode() {

        String lastEmployeeCode = employeeRepository.findMaxIdentityCode();
        String prefix = "EMP";

        if (lastEmployeeCode == null) {
            return prefix + String.format("%04d", 1);
        }

        int nextNumber = Integer.parseInt(lastEmployeeCode.substring(prefix.length())) + 1;
        return prefix + String.format("%04d", nextNumber);
    }
}
