package com.shelterapp.backend.controllers;

import com.shelterapp.backend.dto.LoginDto;
import com.shelterapp.backend.user.User;
import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.models.data.VolunteerRepository;
import com.shelterapp.backend.user.UserRepository;
import com.shelterapp.backend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
    @RequestMapping("/volunteers")
    public class VolunteerController {

        @Autowired
        private final VolunteerRepository volunteerRepository;



        private UserRepository userRepository;

        private UserService userService;

        public VolunteerController(VolunteerRepository volunteerRepository) {
            this.volunteerRepository = volunteerRepository;
        }

        @GetMapping
        public Long getVolIdByUserId(LoginDto loginDto){
            String userName = loginDto.getUsername();
            Optional<User> user = userRepository.findByUsername(userName);
            Long userId = user.get().getId();
            Optional<Volunteer> volunteer = volunteerRepository.findById(userId);
            Long volId = volunteer.get().getId();


            return volId;
        }

        @PostMapping
        public void createVolunteer(@RequestBody Volunteer volunteer) {
            System.out.println(volunteer);
            volunteerRepository.save(volunteer);

        }
    }
