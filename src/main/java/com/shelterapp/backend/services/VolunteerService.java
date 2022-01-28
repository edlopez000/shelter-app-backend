package com.shelterapp.backend.services;

import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerService {

	private final VolunteerRepository volunteerRepository;

	@Autowired
	public VolunteerService(VolunteerRepository volunteerRepository) {
		this.volunteerRepository = volunteerRepository;
	}

	public String getVolunteers() {
//		return List.of(new Volunteer(
//		"First",
//		"Last"
//		));


//		return volunteerRepository.findAll();
		return "test string";
	}

//	public void addNewVolunteer(Volunteer volunteer) {
//		Optional<Volunteer> volunteerOptional = volunteerRepository
//		.findVolunteerByEmail(volunteer.getEmail());
//		if (volunteerOptional.isPresent()) {
//			throw new IllegalStateException("Email already registered.");
//		}
//		volunteerRepository.save(volunteer);
//	}


}
