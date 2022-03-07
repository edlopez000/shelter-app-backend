package com.shelterapp.backend.service;

import com.shelterapp.backend.dto.HouseDto;
import com.shelterapp.backend.entity.Housekeeping;
import com.shelterapp.backend.entity.Volunteer;
import com.shelterapp.backend.repository.HouseRepository;
import com.shelterapp.backend.repository.VolunteerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;


    public ResponseEntity<List<Housekeeping>> findByVolunteerId(UUID id) {
        UUID houseVolunteer = volunteerRepository.findById(id).get().getId();
        Optional<List<Housekeeping>> tasksDone = houseRepository.findHouseByVolunteerId(houseVolunteer);
        if (tasksDone.isPresent()){
        return ResponseEntity.ok(tasksDone.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity saveHouseData(HouseDto houseDto){
        Housekeeping housekeeping = new Housekeeping();
        Optional<Volunteer> volunteer = volunteerRepository.findById(houseDto.getVolunteerId());

        if (volunteer.isPresent()){
            housekeeping.setVolunteer(volunteer.get());

            housekeeping.setSubmitTimestamp(LocalDateTime.now());

            housekeeping.setCleanGroomRoom(houseDto.isHCleanGroomRoom());

            housekeeping.setEmptyWashKongs(houseDto.isHEmptyWashKongs());

            housekeeping.setOrganizeVolArea(houseDto.isHOrganizeVolArea());

            housekeeping.setLaundry(houseDto.isHLaundry());

            housekeeping.setGroundsKeeping(houseDto.isHGroundskeeping());

            houseRepository.save(housekeeping);
            System.out.println(housekeeping);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Housekeeping>> findAll() {
        List<Housekeeping> houseList = houseRepository.findAll();
        return ResponseEntity.ok(houseList);
    }


    public ResponseEntity<Housekeeping> findByHouseId(UUID id) {
        Housekeeping houseTaskById = houseRepository.getById(id);
        return ResponseEntity.ok(houseTaskById);
    }
}
