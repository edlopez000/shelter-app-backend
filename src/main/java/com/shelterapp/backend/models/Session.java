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

//    @ManyToOne
//    @JoinColumn(name = "volunteer_id") //FK
//    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "animal_id") //FK
    private Animal animal;

    @NotNull
    @Column(name = "submit_timestamp")
    private LocalDateTime submitTimestamp;
    @Column(name = "type")
    private RatingEnum type;
    @Column(name = "kennel_out")
    private String kennelOut;
    @Column(name = "kennel_through")
    private String kennelThrough;
    @Column(name = "kennel_in")
    private String kennelIn;
    @Column(name = "shyness")
    private String shyness;
    @Column(name = "leash")
    private String leash;
    @Column(name = "mouthing")
    private String mouthing;
    @Column(name = "jumping")
    private String jumping;
    @Column(name = "c_walk_peed")
    private boolean cWalkPeed;
    @Column(name = "c_walk_pooped")
    private boolean cWalkPooped;
    @Column(name = "c_seems_house_trained")
    private boolean cSeemsHouseTrained;
    @Column(name = "f_playing")
    private boolean fPlaying;
    @Column(name = "f_clean_kennel")
    private boolean fCleanKennel;
    @Column(name = "f_clean_litter")
    private boolean fCleanLitter;
    @Column(name = "f_change_food_water")
    private boolean fChangeFoodWater;
    @Column(name = "h_clean_groom_room")
    private boolean hCleanGroomRoom;
    @Column(name = "h_empty_wash_kongs")
    private boolean hEmptyWashKongs;
    @Column(name = "h_organize_vol_area")
    private boolean hOrganizeVolArea;
    @Column(name = "h_laundry")
    private boolean hLaundry;
    @Column(name = "h_groundskeeping")
    private boolean hGroundskeeping;

}
