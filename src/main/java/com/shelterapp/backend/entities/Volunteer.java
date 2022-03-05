package com.shelterapp.backend.entities;

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
    private long id;

    @NotBlank(message = "Name cannot be left blank.")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 50 characters.")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "Name cannot be left blank.")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 50 characters.")
    @Column(name = "lastName")
    private String lastName;

    @Email
    private String email;

    @NotBlank(message = "Phone cannot be left blank.")
    @Size(min = 10, max = 10, message = "Phone must be 10 digits.")
    @Column(name = "mobilePhone")
    private String mobilePhone;

    @Column(name = "volunteerOrientation")
    private boolean volunteerOrientation;

    @Column(name = "canineOrientation")
    private boolean canineOrientation;

    //@NotBlank(message = "Color Level cannot be left blank.")
    //@Size(min = 4, max = 6, message = "Color Level must be between 4 and 6 characters.")
    @Column(name = "canineColorLevel")
    private String canineColorLevel;

    @Column(name = "felineOrientation")
    private boolean felineOrientation;

    //@NotBlank(message = "Color Level cannot be left blank.")
    //@Size(min = 4, max = 6, message = "Color Level must be between 4 and 6 characters.")
    @Column(name = "felineColorLevel")
    private String felineColorLevel;


}

