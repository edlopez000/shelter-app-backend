package com.shelterapp.backend.dto;


import com.shelterapp.backend.util.enums.RatingEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
@NotNull
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
