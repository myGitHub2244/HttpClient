package co.pragra.learning.webclientdemo.controller;



import co.pragra.learning.webclientdemo.dto.Program;
import co.pragra.learning.webclientdemo.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
public class ProgramController {

    /***            W E B   C L I E N T          ****/
    /*-----------------------------------------------------*/
    
    //This demonstrates one application on port 7072 calling another application on port 8084 using Web Client
    //Postman -> Port 7072 app -> Port 8084 app
    // Ensure the following App is running on Port 8084: C:\Users\jaip2\IdeaProjects\springJPAManyToMany !

            /*
            Following Dependency is added in pom.xml for the Web Client
            <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
            </dependency>
            */

    @Autowired
    ProgramService programService;

    @PostMapping("/addProgram")         //http://localhost:7072/program/addProgram  --> http://localhost:8084/program/addProgram
    public Program addProgram(@RequestBody Program program){
        return programService.addProgram(program);
    }

    //http://localhost:7072/program/allPrograms     --> http://localhost:8084/program/allProgram
    @GetMapping("/allPrograms")     //Fetch all Programs from h2 database using ProgramService
    public List<Program> getAllPrograms(){
        System.out.println("GET method to fetch All Programs");
        return programService.getAllProgram();
    }

    //http://localhost:7072/program/programID?programID=1   --> http://localhost:8084/program/getProgramById"+programID
    @GetMapping("programID")
    public Program getProgramById(@RequestParam("programID") Long programID){
        return programService.getProgramById(programID);
    }

}
