package co.pragra.learning.webclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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



@SpringBootApplication
public class WebClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebClientDemoApplication.class, args);
    }

}
