package co.pragra.learning.feignclientdemo.service;

import co.pragra.learning.feignclientdemo.dto.Program;
import co.pragra.learning.feignclientdemo.httpCLient.ProgramClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class ProgramService {
    @Autowired
    ProgramClient programClient;

    public Program addProgram(Program program) {
        System.out.println("Inside ProgramService to add Program using Feign Client: " + program);
        Program program1 = programClient.addProgram(program);
        return program1;
    }

    public List<Program> getAllProgram() {
        System.out.println("Inside ProgramService to fetch all Program using Feign Client");
        List<Program> allPrograms = programClient.getAllPrograms();
        return allPrograms;
    }


    public Program getProgramById(Long programID) {
        System.out.println("Inside ProgramService to fetch all Program using Feign Client: " + programID);
        Program programById = programClient.getProgramById(programID);
        return programById;
    }

}
