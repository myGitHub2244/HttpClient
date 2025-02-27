package co.pragra.learning.feignclientdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {  //this is Student DTO used to store the Student model/dto actually passed to/from  //http://localhost:8084/student
    private Long studentID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Program> program;
}
