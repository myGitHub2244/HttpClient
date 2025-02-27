package co.pragra.learning.resttemplatedemo.controller;



import co.pragra.learning.resttemplatedemo.dto.Program;
import co.pragra.learning.resttemplatedemo.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/program")
public class ProgramController {

    /***            R E S T    T E M P L A T E          ****/
    /*-----------------------------------------------------*/

    //This demonstrates one application on port 7071 calling another application on port 8084 using RestTemplate (REST API)
    // Refer to ProgramService class to see usage of RestTemplate
    //Postman -> Port 7071 app -> Port 8084 app
    // Ensure the following App is running on Port 8084: C:\Users\jaip2\IdeaProjects\springJPAManyToMany !

    // http calls using Rest Template requires a AppConfig class (@Configuration) which creates RestTemplate bean using @Bean
    // the RestTemplate bean is then autowired and used in ProgramService

    @Autowired
    ProgramService programService;

    @PostMapping("/addProgram")         //http://localhost:7071/program/addProgram
    public Program addProgram(@RequestBody Program program){
        return programService.addProgram(program);      //this method uses RestTemplate "postForObject" method
    }

    @PostMapping("/addProgram1")         //http://localhost:7071/program/addProgram1
    public Program addProgram1(@RequestBody Program program){
        return programService.addProgram1(program);      //this method uses RestTemplate "exchange" method
    }

    //http://localhost:7071/program/allPrograms
    @GetMapping("/allPrograms")     //Fetch all Programs from h2 database using ProgramService
    public List<Program> getAllPrograms(){
        System.out.println("GET method to fetch All Programs");
        return programService.getAllProgram();
    }

    //http://localhost:7071/program/programID?programID=1
    @GetMapping("programID")
    public Program getProgramById(@RequestParam("programID") Long programID){
        return programService.getProgramById(programID);
    }

}
