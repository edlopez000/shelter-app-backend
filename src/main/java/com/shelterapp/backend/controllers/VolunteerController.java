package com.shelterapp.backend.controllers;

import ch.qos.logback.core.net.SMTPAppenderBase;
import com.shelterapp.backend.dto.LoginDto;
import com.shelterapp.backend.user.User;
import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.models.data.VolunteerRepository;
import com.shelterapp.backend.user.UserRepository;
import com.shelterapp.backend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/volunteers")
@CrossOrigin(origins = "http://localhost:3000")
public class VolunteerController {

        @Autowired
        private VolunteerRepository volunteerRepository;

        @Autowired
        private UserRepository userRepository;

        private UserService userService;

        public VolunteerController(VolunteerRepository volunteerRepository) {
            this.volunteerRepository = volunteerRepository;
        }

        @GetMapping
        public List getAllVolunteers(){

//            String userName = loginDto.getUsername();
//            Optional<User> user = userRepository.findByUsername(userName);
//            Long userId = user.get().getId();
//            Optional<Volunteer> volunteer = volunteerRepository.findById(userId);
//            Long volId = volunteer.get().getId();
            return volunteerRepository.findAll();
        }

//        @GetMapping("/{id}")
//        public

        @PostMapping
        public void createVolunteer(@RequestBody Volunteer volunteer) {
            System.out.println(volunteer);
            volunteerRepository.save(volunteer);

        }
    }
