package com.shelterapp.backend.entities;


import com.shelterapp.backend.entities.Volunteer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "volunteerHours")
@Data
public class VolunteerHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id") //FK
    private Volunteer volunteer;

    private LocalDateTime login;

    private LocalDateTime logout;

}
