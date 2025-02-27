package co.pragra.learning.resttemplatedemo.service;

import co.pragra.learning.resttemplatedemo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    public UserDTO getUserDetails(String userName) {
        System.out.println("Inside UserService for user: " + userName);
        return restTemplate.getForObject("https://api.github.com/users/" + userName, UserDTO.class);
    }


}
