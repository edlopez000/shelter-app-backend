package com.shelterapp.backend.dto;

import com.shelterapp.backend.entities.Animal;
import com.shelterapp.backend.entities.Volunteer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionExternalDTO {
    private UUID id;
    private Animal animal;
    private Volunteer volunteer;
    private LocalDateTime submitTimestamp;

}
