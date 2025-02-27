package co.pragra.learning.feignclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/***            F E I G N   C L I E N T          ****/
/*-----------------------------------------------------*/

//This demonstrates one application on port 7072 calling another application on port 8084 using Feign Client
//Postman -> Port 7073 app -> Port 8084 app
// Ensure the following App is running on Port 8084: C:\Users\jaip2\IdeaProjects\springJPAManyToMany !

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

@SpringBootApplication
@EnableFeignClients                             // Enable Feign Client at the Application
public class FeignClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientDemoApplication.class, args);
    }

}
