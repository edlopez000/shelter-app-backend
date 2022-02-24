package com.shelterapp.backend.controllers;

import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    private VolunteerService volunteerService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService) {this.volunteerService = volunteerService;}

    @GetMapping
    public List<Volunteer> getVolunteers() {return volunteerService.findAll();}

    @GetMapping("/{id}")
    public Volunteer getVolunteer(@PathVariable Long id) {return volunteerService.getVolunteer(id);}

    @PostMapping
    public void registerNewVolunteer(@RequestBody Volunteer volunteer) {
        volunteerService.registerNewVolunteer(volunteer);
    }


}
