package co.pragra.learning.webclientdemo.service;

import co.pragra.learning.webclientdemo.dto.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class ProgramService {


    public Program addProgram(Program program) {
        System.out.println("Inside ProgramService to add Program using Web Client: " + program);

        WebClient webClient = WebClient
                .builder()
                .build();

        Mono<Program> programMono = webClient
                .post()
                .uri("http://localhost:8084/program/addProgram",program)
                .retrieve()
                .bodyToMono(Program.class)
                .timeout(Duration.ofMillis(10000));

        Program program1 = programMono.block();
        return program1;
    }

//    Mono and Flux are both implementations of the Publisher interface. When we’re doing a computation or a request to a database
//    or an external service, and expecting a maximum of one result, then we should use Mono.
//    When we’re expecting multiple results from our computation, database, or external service call, then we should use Flux.


    public List<Program> getAllProgram() {
        System.out.println("Inside ProgramService to fetch all Program using Web Client");

        WebClient webClient = WebClient
                .builder()
                .build();
        Mono<List> programMono = webClient
                .get()
                .uri("http://localhost:8084/program/allProgram")
                .retrieve()
                .bodyToMono(List.class)
                .timeout(Duration.ofMillis(10000));

        List<Program> programList = programMono.block();
        return programList;
    }


    public Program getProgramById(Long programID) {
        System.out.println("Inside ProgramService to fetch all Program using Web Client: " + programID);

        WebClient webClient = WebClient
                .builder()
                .build();
        Mono<Program> programMono = webClient
                .get()
                .uri("http://localhost:8084/program/getProgramById"+programID)
                .retrieve()
                .bodyToMono(Program.class)
                .timeout(Duration.ofMillis(10000));

        Program program = programMono.block();
        return program;
    }

}
