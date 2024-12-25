package oatjin.ems_java_backend.controller;

import oatjin.ems_java_backend.dto.ResponseDTO;
import oatjin.ems_java_backend.entity.Employee;
import oatjin.ems_java_backend.repository.EmployeeRepository;
import oatjin.ems_java_backend.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO<Employee>> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

}
