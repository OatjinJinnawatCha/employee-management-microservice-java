package oatjin.ems_java_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private int id;
    private String lastName;
    private String nickName;
    private String firstName;
    private String email;
    private String department;
    private String jobTitle;
}
