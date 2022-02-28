package com.shelterapp.backend.dto;

import com.shelterapp.backend.models.RatingEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
public class SessionDto {
    private Long volunteerId;
    private Long animalId;
    private LocalDateTime submitTimestamp;
    private RatingEnum type;
    private String kennelOut;
    private String kennelThrough;
    private String kennelIn;
    private String shyness;
    private String leash;
    private String mouthing;
    private String jumping;
    private boolean cWalkPeed;
    private boolean cWalkPooped;
    private boolean cSeemsHouseTrained;
    private boolean fPlaying;
    private boolean fCleanKennel;
    private boolean fCleanLitter;
    private boolean fChangeFoodWater;

    private boolean hCleanGroomRoom;
    private boolean hEmptyWashKongs;
    private boolean hOrganizeVolArea;
    private boolean hLaundry;
    private boolean hGroundskeeping;
}
