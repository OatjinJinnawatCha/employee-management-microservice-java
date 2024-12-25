package oatjin.ems_java_backend.service;

import oatjin.ems_java_backend.dto.EmployeeDTO;
import oatjin.ems_java_backend.dto.ResponseDTO;
import oatjin.ems_java_backend.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmployeeService {
    ResponseEntity<ResponseDTO<Employee>> addEmployee(Employee employee);
}
