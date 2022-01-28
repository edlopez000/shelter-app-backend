package com.shelterapp.backend.controllers;

import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "volunteer")
public class VolunteerController {

	private final VolunteerService volunteerService;

	@Autowired
	public VolunteerController(VolunteerService volunteerService) {
		this.volunteerService = volunteerService;
	}

	@GetMapping
	public String getVolunteers(){
		return volunteerService.getVolunteers();
	}

}
