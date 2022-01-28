package com.shelterapp.backend.volunteer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

	private final VolunteerRepository volunteerRepository;

	@Autowired
	public VolunteerService(VolunteerRepository volunteerRepository) {
		this.volunteerRepository = volunteerRepository;
	}

	public List<Volunteer> getVolunteers() {
		return volunteerRepository.findAll();
	}

	public void addNewVolunteer(Volunteer volunteer) {
		Optional<Volunteer> volunteerOptional = volunteerRepository
		.findVolunteerByEmail(volunteer.getEmail());
		if (volunteerOptional.isPresent()) {
			throw new IllegalStateException("Email already registered.");
		}
		volunteerRepository.save(volunteer);
	}


}
