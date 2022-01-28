package com.shelterapp.backend.volunteer;

import com.shelterapp.backend.volunteer.Volunteer;
import com.shelterapp.backend.volunteer.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public List<Volunteer> getVolunteers(){
		return volunteerService.getVolunteers();
	}

	@PostMapping
	public void registerNewVolunteer(@RequestBody Volunteer volunteer) {
		volunteerService.addNewVolunteer(volunteer);
	}

}
