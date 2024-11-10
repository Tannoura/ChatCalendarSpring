package com.example.demo.services;


import com.example.demo.entities.user;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private  UserRepo userRepository;



    public List<user> getAllUsers() {
        return userRepository.findAll(); // Utilisez la méthode findAll() du repository pour récupérer tous les utilisateurs
    }
    public user saveUser(user user) {
        return userRepository.save(user);
    }
}
