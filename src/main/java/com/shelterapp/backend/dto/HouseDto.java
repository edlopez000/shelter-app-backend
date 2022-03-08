package com.shelterapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {

    //JSON packet key string must match exactly with column name, case and syntax
    //if not posting booleans, GET request to see the formatting of the column names
    //copy and paste from the ResponseBody, the exact column name

    private LocalDateTime submitTimestamp;

    private UUID volunteerId;

    private boolean cleanGroomRoom;

    private boolean emptyWashKongs;

    private boolean organizeVolArea;

    private boolean laundry;

    private boolean groundsKeeping;


}
