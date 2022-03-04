package com.shelterapp.backend.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id") //FK
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "animal_id") //FK
    private Animal animal;

    @NotNull
    @Column(name = "submit_timestamp")
    private LocalDateTime submitTimestamp;

    //Both Cats and Dogs sessions will ulimately end up in SessionRepo, however
    //they should be filtered so each session is isolated as one animal species specific activies
    //so as not to have nulls or whatnot
    //Dogs Activities to be Mapped from this into a DTO into the receiving point
    @Column(name = "kennel_out")
    private RatingEnum kennelOut;
    @Column(name = "kennel_through")
    private RatingEnum kennelThrough;
    @Column(name = "kennel_in")
    private RatingEnum kennelIn;
    @Column(name = "shyness")
    private RatingEnum shyness;
    @Column(name = "leash")
    private RatingEnum leash;
    @Column(name = "mouthing")
    private RatingEnum mouthing;
    @Column(name = "jumping")
    private RatingEnum jumping;
    @Column(name = "c_walk_peed")
    private boolean cWalkPeed;
    @Column(name = "c_walk_pooped")
    private boolean cWalkPooped;
    @Column(name = "c_seems_house_trained")
    private boolean cSeemsHouseTrained;

    //Cats Activities to be Mapped through a DIFFERENT DTO
    @Column(name = "f_playing")
    private boolean fPlaying;
    @Column(name = "f_clean_kennel")
    private boolean fCleanKennel;
    @Column(name = "f_clean_litter")
    private boolean fCleanLitter;
    @Column(name = "f_change_food_water")
    private boolean fChangeFoodWater;


}
