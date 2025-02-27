package co.pragra.learning.feignclientdemo.restController;

import co.pragra.learning.feignclientdemo.dto.Program;
import co.pragra.learning.feignclientdemo.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
public class ProgramController {

    /***            F E I G N   C L I E N T          ****/
    /*-----------------------------------------------------*/

//This demonstrates one application on port 7072 calling another application on port 8084 using Feign Client
//Postman -> Port 7073 app -> Port 8084 app
// Ensure the following App is running on Port 8084: C:\Users\jaip2\IdeaProjects\springJPAManyToMany !

// Feign Client e.g. ProgramClient requires a class annotated as @FeignClient that actually does HTTP service to another app

            /*
Following properties, dependencies and dependency management is required to be added to pom.xml
  <properties>
    <spring-cloud.version>2023.0.2</spring-cloud.version>           **** spring-cloud.version
  </properties>

    <dependencies>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-openfeign</artifactId>       **** spring-cloud-starter-openfeign
    </dependency>

      <dependencyManagement>                                        **** <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>${spring-cloud.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
      </dependencyManagement>
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
