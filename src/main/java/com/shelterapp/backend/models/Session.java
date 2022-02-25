package com.shelterapp.backend.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "session")
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
    private RatingEnum type;
    @Column(name = "kennel_out")
    private String kennelOut;
    @Column(name = "kennel_through")
    private String kennelThrough;
    @Column(name = "kennel_in")
    private String kennelIn;
    private String shyness;
    private String leash;
    private String mouthing;
    private String jumping;
    @Column(name = "c_walk_peed")
    private Boolean cWalkPeed;
    @Column(name = "c_walk_pooped")
    private Boolean cWalkPooped;
    @Column(name = "c_seems_house_trained")
    private Boolean cSeemsHouseTrained;
    @Column(name = "f_playing")
    private Boolean fPlaying;
    @Column(name = "f_clean_kennel")
    private Boolean fCleanKennel;
    @Column(name = "f_clean_litter")
    private Boolean fCleanLitter;
    @Column(name = "f_change_food_water")
    private Boolean fChangeFoodWater;
    @Column(name = "h_clean_groom_room")
    private Boolean hCleanGroomRoom;
    @Column(name = "h_empty_wash_kongs")
    private Boolean hEmptyWashKongs;
    @Column(name = "h_organize_vol_area")
    private Boolean hOrganizeVolArea;
    @Column(name = "h_laundry")
    private Boolean hLaundry;
    @Column(name = "h_groundskeeping")
    private Boolean hGroundskeeping;
    @Column(name = "e_treats")
    private Boolean eTreats;
    @Column(name = "e_toys")
    private Boolean eToys;
    @Column(name = "e_playing")
    private Boolean ePlaying;
    @Column(name = "e_cuddle_time")
    private Boolean eCuddleTime;

//look into @Column and Flyway...
    //look into setting default boolean to false. Maybe @ColumnDefault?


}
