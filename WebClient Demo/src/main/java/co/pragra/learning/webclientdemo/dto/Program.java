package co.pragra.learning.webclientdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {      //this is Program DTO used to store the Program model/dto actually passed to/from  //http://localhost:8084/program
    private Long programID;
    private String programName;
    private String programDescription;
    private String instructorName;
    private LocalDate programStartDate = LocalDate.now().plusMonths(1);
    private List<Student> students;

}
