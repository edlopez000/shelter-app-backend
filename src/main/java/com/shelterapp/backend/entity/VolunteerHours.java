package com.shelterapp.backend.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "volunteerHours")
@Data
public class VolunteerHours {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id") //FK
    private Volunteer volunteer;

    private LocalDateTime login;

    private LocalDateTime logout;

}
