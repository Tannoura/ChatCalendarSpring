package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String imageUrl;
    private String imageId;

    public Image(String name, String imageUrl, String imageId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
    }

}
