package com.shelterapp.backend.entities;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "animal")
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Species cannot be left blank.")
    @Size(min = 3, max = 50, message = "Species must be between 3 and 50 characters.")
    private String species;

    @NotBlank(message = "Name cannot be left blank.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    private String name;

    @NotBlank(message = "Color level must not be left blank.")
    @Size(min = 3, max = 50, message = "Color level must be between 3 and 50 characters.")
    @Column(name = "colorLevel")
    private String colorLevel;

    @NotNull
    @Column(name = "intakeDate")
    private LocalDateTime intakeDate;

    @NotNull
    @Column(name = "exitDate")
    private LocalDateTime exitDate;

    @NotNull
    private boolean adoptable;  //logic for if adoptable is false then rescueOnly must be true and vice versa

    @NotNull
    @Column(name = "rescueOnly")
    private boolean rescueOnly; //logic for if rescueOnly is false then adoptable must be true and vice versa

}
