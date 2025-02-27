package co.pragra.learning.resttemplatedemo.controller;

import co.pragra.learning.resttemplatedemo.dto.UserDTO;
import co.pragra.learning.resttemplatedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/userName")    //http://localhost:7071/users/userName?userName=myGitHub2244
    public UserDTO getUser(@RequestParam("userName") String userName) {
        System.out.println("Get Method found. Now fetch User details");
        return userService.getUserDetails(userName);
    }

}
