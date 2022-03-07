package com.shelterapp.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto {
    private UUID volunteerId;
    private UUID animalId;
    private String kennelOut;
    private String kennelThrough;
    private String kennelIn;
    private String shyness;
    private String leash;
    private String mouthing;
    private String jumping;
    private boolean cWalkPeed;
    private boolean cWalkPooped;
    private boolean cHouseTrained;

    private boolean fPlaying;
    private boolean fCleanKennel;
    private boolean fCleanLitter;
    private boolean fChangeFoodWater;
}
