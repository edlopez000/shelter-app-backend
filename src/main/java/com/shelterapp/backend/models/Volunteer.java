package com.shelterapp.backend.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "volunteer")
@Data
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Integer mobilePhone;
    private Boolean volunteerOrientation;
    private Boolean canineOrientation;
    private Boolean canineColorLevel;
    private Boolean felineOrientation;
    private Boolean felineColorLevel;


}

