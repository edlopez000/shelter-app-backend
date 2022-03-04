package com.shelterapp.backend.controllers;

import com.shelterapp.backend.dto.LoginDto;
import com.shelterapp.backend.models.Housekeeping;
import com.shelterapp.backend.models.data.HouseRepository;
import com.shelterapp.backend.service.HouseService;
import com.shelterapp.backend.dto.HouseDto;
import com.shelterapp.backend.user.User;
import com.shelterapp.backend.user.UserRepository;
import com.shelterapp.backend.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/housekeeping")
@CrossOrigin(origins = "http://localhost:3000")
public class HouseController {

    @Autowired
    private HouseService houseService;

    private HouseRepository houseRepository;

    @Autowired
    private UserService userService;

////  @Autowired
//    private ModelMapper modelMapper;
//
//
//    @Bean
//    public ModelMapper modelMapper() {
//        return new ModelMapper();
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public ResponseEntity createHouseKept(@RequestBody HouseDto houseDto) throws ParseException {
        Housekeeping houseTask = convertToEntity(houseDto);
        houseRepository.save(houseTask);
        System.out.println(houseTask);
        return ResponseEntity.ok().build();

    }


    private HouseDto convertToDto(Housekeeping housekeeping) {

        ModelMapper modelMapper = new ModelMapper();
        HouseDto houseDto = modelMapper.map(housekeeping, HouseDto.class);

        return houseDto;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public HouseDto getHousekept(@PathVariable("id") Long id){
        return convertToDto(houseService.findByVolunteerId(id));
    }

    private Housekeeping convertToEntity(HouseDto houseDto) throws ParseException{
        ModelMapper modelMapper = new ModelMapper();
        Housekeeping houseTask = modelMapper.map(houseDto, Housekeeping.class);

        if (houseDto.getVolunteerId() != null){
            Housekeeping housekeeping = houseService.findByVolunteerId(houseDto.getVolunteerId());
            houseTask.setHCleanGroomRoom(
                    housekeeping.isHCleanGroomRoom());
            houseTask.setHEmptyWashKongs(
                    housekeeping.isHEmptyWashKongs());
            houseTask.setHOrganizeVolArea(
                    housekeeping.isHOrganizeVolArea());
            houseTask.setHLaundry(
                    housekeeping.isHLaundry());
            houseTask.setHGroundskeeping(
                    housekeeping.isHGroundskeeping());
        }
        return houseTask;
    };

//    public HouseController(HouseService houseService) {
//        this.houseService = houseService;
//    }
//
//    @Autowired
//    @PostMapping
//    public ResponseEntity createHousekept(@RequestBody HouseDto houseDto){
//        return houseService.saveHouseData(houseDto);
//    }
//
//    @GetMapping
//    public List<Housekeeping> getAllHousekept(){
//        return houseService.findAll();
//    }
//

}
