package com.shelterapp.backend.models;


import javax.persistence.*;

@Entity
@Table(name = "volunteerHours")
public class VolunteerHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id") //FK
    private Long volunteerId;
}
