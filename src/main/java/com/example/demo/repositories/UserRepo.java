package com.example.demo.repositories;

import com.example.demo.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<user,Integer> {
}
