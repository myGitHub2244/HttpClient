package co.pragra.learning.feignclientdemo.httpCLient;

import co.pragra.learning.feignclientdemo.dto.Program;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="programClient",url="http://localhost:8084/program")
public interface ProgramClient {

    @PostMapping("/addProgram")         //http://localhost:7073/program/addProgram  --> http://localhost:8084/program/addProgram
    public Program addProgram(@RequestBody Program program);


    @GetMapping("/allPrograms")         //http://localhost:7073/program/allPrograms     --> http://localhost:8084/program/allProgram
    public List<Program> getAllPrograms();


    @GetMapping("/programID")           //http://localhost:7073/program/programID?programID=1   --> http://localhost:8084/program/getProgramById"+programID
    public Program getProgramById(@RequestParam("programID") Long programID);

}
