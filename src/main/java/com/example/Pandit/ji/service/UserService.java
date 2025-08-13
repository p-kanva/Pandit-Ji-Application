package com.example.Pandit.ji.service;

import com.example.Pandit.ji.Model.User;
import com.example.Pandit.ji.exception.ResourceAlreadyExistsException;
import com.example.Pandit.ji.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User registerUser(User user){

          if(userRepository.findByEmail(user.getEmail()).isPresent()){
              throw new ResourceAlreadyExistsException("Email is already Registered");
          }

          if(userRepository.findByMobileNumber(user.getMobileNumber()).isPresent()){
              throw new ResourceAlreadyExistsException("Mobile No. is already Registered");
          }

        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
