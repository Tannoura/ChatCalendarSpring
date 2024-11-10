package com.example.demo.controllers;


import com.example.demo.entities.Image;
import com.example.demo.entities.user;
import com.example.demo.services.CloudinaryService;
import com.example.demo.services.ImageService;
import com.example.demo.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {


    @Autowired
    CloudinaryService cloudinaryService;
    @Autowired
    ImageService imageService;
    @Autowired
    userService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestParam("nom") String nom,
                                          @RequestParam("photo") MultipartFile photo) throws IOException {
        // Vérifiez si l'image est vide ou non
        if (!photo.isEmpty()) {
            // Upload de l'image sur Cloudinary
            Map result = cloudinaryService.upload(photo);
            String photoUrl = (String) result.get("url");

            // Créez un nouvel objet Image
            Image image = new Image();
            image.setName(photo.getOriginalFilename());
            image.setImageUrl(photoUrl);
            image.setImageId((String) result.get("public_id"));
            imageService.save(image);

            // Créez un nouvel objet User avec le nom et l'image associée
            user user = new user();
            user.setNom(nom);
            user.setImage(image);
            userService.saveUser(user);

            return new ResponseEntity<>("Utilisateur ajouté avec succès !", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Veuillez sélectionner une image.", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/list")
    public ResponseEntity<List<user>> getUsers() {
        List<user> users = userService.getAllUsers(); // Implémentez cette méthode dans votre service
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}

