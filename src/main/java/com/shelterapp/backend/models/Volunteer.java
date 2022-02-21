package com.shelterapp.backend.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "volunteer")
@Data
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name cannot be left blank.")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 50 characters.")
    private String firstName;
    @NotBlank(message = "Name cannot be left blank.")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 50 characters.")
    private String lastName;
    @Email
    private String email;
    @NotBlank(message = "Phone cannot be left blank.")
    @Size(min = 10, max = 10, message = "Phone must be 10 digits.")
    private String mobilePhone;
    private boolean volunteerOrientation;
    private boolean canineOrientation;
    @NotBlank(message = "Color Level cannot be left blank.")
    @Size(min = 4, max = 6, message = "Color Level must be between 4 and 6 characters.")
    private String canineColorLevel;
    private boolean felineOrientation;
    @NotBlank(message = "Color Level cannot be left blank.")
    @Size(min = 4, max = 6, message = "Color Level must be between 4 and 6 characters.")
    private String felineColorLevel;


}

