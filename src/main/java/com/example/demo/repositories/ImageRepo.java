package com.example.demo.repositories;

import com.example.demo.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepo extends JpaRepository<Image,Integer> {
    List<Image> findByOrderById();

}
