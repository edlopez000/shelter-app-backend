package com.shelterapp.backend.service;

import com.shelterapp.backend.entities.Animal;
import com.shelterapp.backend.dto.SessionDto;
import com.shelterapp.backend.entities.Session;
import com.shelterapp.backend.entities.Volunteer;
import com.shelterapp.backend.repository.AnimalRepository;
import com.shelterapp.backend.repository.SessionRepository;
import com.shelterapp.backend.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private final SessionRepository sessionRepository;

    @Autowired
    private final VolunteerRepository volunteerRepository;

    @Autowired
    private final AnimalRepository animalRepository;


    public SessionService(AnimalRepository animalRepository,
                          VolunteerRepository volunteerRepository,
                          SessionRepository sessionRepository
    ) {
        this.animalRepository = animalRepository;
        this.volunteerRepository = volunteerRepository;
        this.sessionRepository = sessionRepository;
    }

    @PostMapping("/session")
    public ResponseEntity saveSessionData(SessionDto sessionDto) {
        Session session = new Session();
        Optional<Volunteer> volunteer = volunteerRepository.findById(sessionDto.getVolunteerId());
        Optional<Animal> animal = animalRepository.findById(sessionDto.getAnimalId());
        if (volunteer.isPresent() && animal.isPresent()) {
            session.setAnimal(animal.get());
            session.setVolunteer(volunteer.get());
            session.setSubmitTimestamp(LocalDateTime.now());
//            session.setKennelOut(sessionDto.getType());
//            session.setKennelThrough(sessionDto.getType());
//            session.setKennelIn(sessionDto.getKennelIn());
//            session.setShyness(sessionDto.getShyness());
//            session.setLeash(sessionDto.getType());
//            session.setMouthing(sessionDto.getType());
//            session.setJumping(sessionDto.getType());
            session.setCWalkPeed(sessionDto.isCWalkPeed());
            session.setCWalkPooped(sessionDto.isCWalkPooped());
            session.setCSeemsHouseTrained(sessionDto.isCSeemsHouseTrained());

            session.setFPlaying(sessionDto.isFPlaying());
            session.setFCleanKennel(sessionDto.isFCleanKennel());
            session.setFCleanLitter(sessionDto.isFCleanKennel());
            session.setFChangeFoodWater(sessionDto.isFChangeFoodWater());
            sessionRepository.save(session);
            System.out.println(session);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public List<Session> findByAnimalId(Long id) {
        Animal animal = animalRepository.getById(id);

        return sessionRepository.findAllByAnimalId(animal.getId());
    };

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }
}