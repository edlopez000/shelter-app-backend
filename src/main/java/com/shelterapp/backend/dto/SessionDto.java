package com.shelterapp.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto {

    //JSON packet key string must match exactly with column name, case and syntax
    //if not posting booleans, GET request to see the formatting of the column names
    //copy and paste from the ResponseBody, the exact column name

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

//    private boolean fPlaying;
//    private boolean fCleanKennel;
//    private boolean fCleanLitter;
//    private boolean fChangeFoodWater;
}
