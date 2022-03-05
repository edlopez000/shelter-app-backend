package com.shelterapp.backend.service;

import com.shelterapp.backend.entities.Housekeeping;
import com.shelterapp.backend.entities.Volunteer;
import com.shelterapp.backend.repository.HouseRepository;
import com.shelterapp.backend.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    private final VolunteerRepository volunteerRepository;

    @Autowired
    public HouseService(VolunteerRepository volunteerRepository,
                        HouseRepository houseRepository
    ) {
        this.houseRepository=houseRepository;
        this.volunteerRepository=volunteerRepository;
    }

    public Housekeeping findByVolunteerId(Long id) {


        Optional<Volunteer> houseVolunteer = volunteerRepository.findById(id);
        List<Housekeeping> tasksDone = houseRepository.findById(houseVolunteer.get().getId()).stream().toList();
        Housekeeping task = tasksDone.get(0);
        return task;
    }
//    @PostMapping("/housekept")
//    public ResponseEntity saveHouseData(HouseDto houseDto){
//        Housekeeping housekeeping = new Housekeeping();
//        Volunteer volunteer = volunteerRepository.findById(
//                houseDto.getVolunteerId());
//
//        if (volunteer.isPresent()){
//            housekeeping.setVolunteer(volunteer.get());
//
//            housekeeping.setSubmitTimestamp(LocalDateTime.now());
//
//            housekeeping.setHCleanGroomRoom(
//                    houseDto.isHCleanGroomRoom());
//            housekeeping.setHEmptyWashKongs(
//                    houseDto.isHEmptyWashKongs());
//            housekeeping.setHOrganizeVolArea(
//                    houseDto.isHOrganizeVolArea());
//            housekeeping.setHLaundry(
//                    houseDto.isHLaundry());
//            housekeeping.setHGroundskeeping(
//                    houseDto.isHGroundskeeping());
//
//            houseRepository.save(housekeeping);
//            System.out.println(housekeeping);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }

//    public List<Housekeeping> findAll() {
//        return null;
//    }


}
