package com.example.cart.service;

import com.example.cart.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    public User getUserById(String userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/users/";
        ResponseEntity<User> response = restTemplate.getForEntity(url + userId, User.class);
        return response.getBody();
    }
}
