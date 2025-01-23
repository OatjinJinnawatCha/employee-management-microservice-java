package oatjin.ems_java_backend.repository;

import oatjin.ems_java_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT MAX(e.employeeCode) FROM Employee e WHERE e.employeeCode LIKE 'EMP%'")
    String findMaxIdentityCode();
    Employee findByEmployeeCode(String employeeCode);
}
