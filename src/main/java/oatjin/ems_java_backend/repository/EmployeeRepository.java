package oatjin.ems_java_backend.repository;

import oatjin.ems_java_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
