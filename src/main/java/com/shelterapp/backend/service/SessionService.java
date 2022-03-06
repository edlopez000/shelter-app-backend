package com.shelterapp.backend.service;

import com.shelterapp.backend.entity.Animal;
import com.shelterapp.backend.dto.SessionDto;
import com.shelterapp.backend.entity.Session;
import com.shelterapp.backend.entity.Volunteer;
import com.shelterapp.backend.repository.AnimalRepository;
import com.shelterapp.backend.repository.SessionRepository;
import com.shelterapp.backend.repository.VolunteerRepository;
import com.shelterapp.backend.util.enums.RatingEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public ResponseEntity saveSessionData(SessionDto sessionDto) {
        Session session = new Session();
        Optional<Volunteer> volunteer = volunteerRepository.findById(sessionDto.getVolunteerId());
        Optional<Animal> animal = animalRepository.findById(sessionDto.getAnimalId());
        if (volunteer.isPresent() && animal.isPresent()) {
            session.setAnimal(animal.get());
            session.setVolunteer(volunteer.get());
            session.setSubmitTimestamp(LocalDateTime.now());
            session.setKennelOut(evaluateEnum(sessionDto.getKennelOut()));
            session.setKennelThrough(evaluateEnum(sessionDto.getKennelThrough()));
            session.setKennelIn(evaluateEnum(sessionDto.getKennelIn()));
            session.setShyness(evaluateEnum(sessionDto.getShyness()));
            session.setLeash(evaluateEnum(sessionDto.getLeash()));
            session.setMouthing(evaluateEnum(sessionDto.getMouthing()));
            session.setJumping(evaluateEnum(sessionDto.getJumping()));
            session.setCWalkPeed(sessionDto.isCWalkPeed());
            session.setCWalkPooped(sessionDto.isCWalkPooped());
            session.setCSeemsHouseTrained(sessionDto.isCSeemsHouseTrained());
            sessionRepository.save(session);
            System.out.println(session);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Session>> findByAnimalId(UUID id) {
        Optional<List<Session>> listOfSessions = sessionRepository.findSessionByAnimalId(id);
        if (listOfSessions.isPresent()) {
            return ResponseEntity.ok(listOfSessions.get());
        }
        return ResponseEntity.notFound().build();
    };

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    private RatingEnum evaluateEnum(String jsonValue) {
        switch (jsonValue) {
            case "MILD":
                return RatingEnum.MILD;
            case "MODERATE":
                return RatingEnum.MODERATE;
            case "SIGNIFICANT":
                return RatingEnum.SIGNIFICANT;
            case "NO":
            default:
                return RatingEnum.NO;

        }
    }
}