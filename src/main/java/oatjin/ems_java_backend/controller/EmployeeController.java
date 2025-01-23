package oatjin.ems_java_backend.controller;

import oatjin.ems_java_backend.dto.ResponseDTO;
import oatjin.ems_java_backend.entity.Employee;
import oatjin.ems_java_backend.repository.EmployeeRepository;
import oatjin.ems_java_backend.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findEmployee/{employeeCode}")
    public Employee getEmployeeByEmployeeCode(@PathVariable String employeeCode) {
        return employeeRepository.findByEmployeeCode(employeeCode);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO<Employee>> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public ResponseDTO<Employee> updateEmployee(@RequestParam String employeeCode, @RequestBody Employee newInput) {
        return employeeService.updateEmployeeByEmployeeCode(employeeCode, newInput);
    }

    @DeleteMapping("/delete/{employeeCode}")
    public ResponseDTO<Employee> deleteEmployee(@PathVariable String employeeCode) {
        return employeeService.deleteEmployeeByEmployeeCode(employeeCode);
    }
}
