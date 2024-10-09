package com.example.user.service;

import com.example.user.domain.User;
import com.example.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    public UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, String id) {
        var updateUser = this.findUserById(id);
        updateUser = user;
        return userRepository.save(updateUser);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(new ObjectId(id));
    }

    public User findUserById(String id) {
        return userRepository.findById(new ObjectId(id)).orElseThrow(() ->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found."
        ));
    }
}
