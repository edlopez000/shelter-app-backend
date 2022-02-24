package com.shelterapp.backend.service;

import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.models.data.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    private final VolunteerRepository volunteerRepository;

    @Autowired
    public VolunteerService(VolunteerRepository volunteerRepository) {this.volunteerRepository = volunteerRepository;}

    public void registerNewVolunteer(Volunteer volunteer) {volunteerRepository.save(volunteer);}

    public Volunteer getVolunteer(Long id) {return volunteerRepository.findById(id).orElseThrow(RuntimeException::new);}

    public List<Volunteer> findAll() {
        return volunteerRepository.findAll();
    }
}
