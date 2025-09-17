package com.example.Pandit.ji.service;

import com.example.Pandit.ji.Model.User;
import com.example.Pandit.ji.exception.ResourceAlreadyExistsException;
import com.example.Pandit.ji.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

//    @Autowired
//    private User user;

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public User registerUser(User user){

          if(userRepository.findByEmail(user.getEmail()).isPresent()){
              throw new ResourceAlreadyExistsException("Email is already Registered");
          }

          if(userRepository.findByMobileNumber(user.getMobileNumber()).isPresent()){
              throw new ResourceAlreadyExistsException("Mobile No. is already Registered");
          }
          user.setPassword(passwordEncoder.encode(user.getPassword()));


        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
