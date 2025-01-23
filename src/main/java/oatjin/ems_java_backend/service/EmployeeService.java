package oatjin.ems_java_backend.service;

import oatjin.ems_java_backend.dto.ResponseDTO;
import oatjin.ems_java_backend.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<ResponseDTO<Employee>> addEmployee(Employee employee);
    ResponseDTO<Employee> updateEmployeeByEmployeeCode(String employeeCode, Employee newEmployee);
    ResponseDTO<Employee> deleteEmployeeByEmployeeCode(String employeeCode);
}
