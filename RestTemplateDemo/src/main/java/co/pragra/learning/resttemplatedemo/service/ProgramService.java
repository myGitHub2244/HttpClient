package co.pragra.learning.resttemplatedemo.service;

import co.pragra.learning.resttemplatedemo.dto.Program;
import co.pragra.learning.resttemplatedemo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {

    @Autowired
    RestTemplate restTemplate;

    public Program addProgram(Program program) {
        System.out.println("Inside ProgramService to add Program using RestTemplate postForObject method: " + program);
        return restTemplate.postForObject("http://localhost:8084/program/addProgram", program, Program.class);
    }


    //another flavor is using the exchange method. The advantage is we can overload using HttpMethod.GET/POST as needed
    //Response received in form of ResponseEntity<T> object !
    // Also the response received can be used to fetch various details such as getBody or getHeaders etc.

    public Program addProgram1(Program program) {
        System.out.println("Inside ProgramService to add Program using RestTemplate exchange method: " + program);
        HttpEntity<Program> programHttpEntity = new HttpEntity<>(program);
        ResponseEntity<Program> programResponseEntity = restTemplate.exchange("http://localhost:8084/program/addProgram",
                HttpMethod.POST,programHttpEntity,Program.class);
        Program program1 = programResponseEntity.getBody();     //get Body
        HttpHeaders headers = programResponseEntity.getHeaders();   // get Headers
        return program1;
    }

    public List<Program> getAllProgram() {
        System.out.println("Inside ProgramService to fetch all Program");
        return restTemplate.getForObject("http://localhost:8084/program/allProgram", List.class);
    }

        public Program getProgramById(Long programID) {
        System.out.println("Inside ProgramService to fetch all Program");
        return restTemplate.getForObject("http://localhost:8084/program/programID?programID="+programID, Program.class);
    }

}
