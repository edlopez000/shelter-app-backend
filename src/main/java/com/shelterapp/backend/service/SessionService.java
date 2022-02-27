package com.shelterapp.backend.service;

import com.shelterapp.backend.models.Animal;
import com.shelterapp.backend.dto.SessionDto;
import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.models.data.AnimalRepository;
import com.shelterapp.backend.models.data.SessionRepository;
import com.shelterapp.backend.models.data.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    private final VolunteerRepository volunteerRepository;

    private final AnimalRepository animalRepository;

    @Autowired
    public SessionService(AnimalRepository animalRepository, VolunteerRepository volunteerRepository, SessionRepository sessionRepository) {
        this.animalRepository = animalRepository;
        this.volunteerRepository = volunteerRepository;
        this.sessionRepository = sessionRepository;

    }


    public void saveSessionData(SessionDto sessionDTO) {
        Volunteer volunteer = VolunteerRepository.findById();
        Animal animal = AnimalRepository.findById
    }
}
