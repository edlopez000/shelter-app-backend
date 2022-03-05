package com.shelterapp.backend.dto;


import com.shelterapp.backend.models.RatingEnum;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class SessionDto {
    private Long volunteerId;
    private Long animalId;

    private LocalDateTime submitTimestamp;
    private RatingEnum type;

//    private String kennelOut;
//    private String kennelThrough;
//    private String kennelIn;
//    private String shyness;
    private boolean leash;
    private boolean mouthing;
    private boolean jumping;
    private boolean cWalkPeed;
    private boolean cWalkPooped;
    private boolean cSeemsHouseTrained;
    private boolean fPlaying;
    private boolean fCleanKennel;
    private boolean fCleanLitter;
    private boolean fChangeFoodWater;


}
