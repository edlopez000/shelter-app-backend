package com.shelterapp.backend.controllers;

import com.shelterapp.backend.entities.Volunteer;
import com.shelterapp.backend.repository.VolunteerRepository;
import com.shelterapp.backend.user.UserRepository;
import com.shelterapp.backend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/volunteers")
@CrossOrigin(origins = "http://localhost:3000")
public class VolunteerController {

        @Autowired
        private VolunteerRepository volunteerRepository;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private UserService userService;

        @GetMapping
        public List<Volunteer> getAllVolunteers(){
            return volunteerRepository.findAll();
        }

        @PostMapping
        public void createVolunteer(@RequestBody Volunteer volunteer) {
            volunteerRepository.save(volunteer);
        }
    }
