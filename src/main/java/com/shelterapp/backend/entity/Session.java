package com.shelterapp.backend.entity;

import com.shelterapp.backend.util.enums.RatingEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sessions")
@Data
public class Session {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    private LocalDateTime submitTimestamp;

    //Dogs Activities to be Mapped from this into a DTO into the receiving point
    @Enumerated(EnumType.STRING)
    private RatingEnum kennelOut;

    @Enumerated(EnumType.STRING)
    private RatingEnum kennelThrough;

    @Enumerated(EnumType.STRING)
    private RatingEnum kennelIn;

    @Enumerated(EnumType.STRING)
    private RatingEnum shyness;

    @Enumerated(EnumType.STRING)
    private RatingEnum leash;

    @Enumerated(EnumType.STRING)
    private RatingEnum mouthing;

    @Enumerated(EnumType.STRING)
    private RatingEnum jumping;

    private boolean cWalkPeed;
    private boolean cWalkPooped;
    private boolean cHouseTrained;
//
//    //Cats Activities to be Mapped through a DIFFERENT DTO
//    @Column(name = "f_playing")
//    private boolean fPlaying;
//    @Column(name = "f_clean_kennel")
//    private boolean fCleanKennel;
//    @Column(name = "f_clean_litter")
//    private boolean fCleanLitter;
//    @Column(name = "f_change_food_water")
//    private boolean fChangeFoodWater;


}
