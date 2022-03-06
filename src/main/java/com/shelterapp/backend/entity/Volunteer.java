package com.shelterapp.backend.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "volunteer")
@Data
public class Volunteer {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

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

    private String canineColorLevel;

    private boolean felineOrientation;

    private String felineColorLevel;


}

