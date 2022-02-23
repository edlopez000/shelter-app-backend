package com.shelterapp.backend.controllers;

import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.models.data.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @PostMapping
    public void createVolunteer(@RequestBody Volunteer volunteer) {
        System.out.println(volunteer);
        volunteerRepository.save(volunteer);

    }
}
