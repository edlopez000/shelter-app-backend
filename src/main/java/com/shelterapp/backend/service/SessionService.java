package com.shelterapp.backend.service;

import com.shelterapp.backend.models.Animal;
import com.shelterapp.backend.dto.SessionDto;
import com.shelterapp.backend.models.Session;
import com.shelterapp.backend.models.Volunteer;
import com.shelterapp.backend.models.data.AnimalRepository;
import com.shelterapp.backend.models.data.SessionRepository;
import com.shelterapp.backend.models.data.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/session")
    public ResponseEntity saveSessionData(SessionDto sessionDto) {
        Session session = new Session();
        Optional<Volunteer> volunteer = volunteerRepository.findById(sessionDto.getVolunteerId());
        Optional<Animal> animal = animalRepository.findById(sessionDto.getAnimalId());
        if (volunteer.isPresent() && animal.isEmpty()) {
            session.setVolunteer(volunteer.get());
            session.setSubmitTimestamp(LocalDateTime.now());
            session.setHCleanGroomRoom(sessionDto.isHCleanGroomRoom());
            session.setHEmptyWashKongs(sessionDto.isHEmptyWashKongs());
            session.setHLaundry(sessionDto.isHLaundry());
            session.setHOrganizeVolArea(sessionDto.isHOrganizeVolArea());
            session.setHGroundskeeping(sessionDto.isHGroundskeeping());
            sessionRepository.save(session);
            System.out.println(session);
            return ResponseEntity.ok().build();
        } else if (volunteer.isPresent()) {
            session.setAnimal(animal.get());
            session.setVolunteer(volunteer.get());
            session.setSubmitTimestamp(LocalDateTime.now());
            session.setType(sessionDto.getType());
            session.setKennelOut(sessionDto.getKennelOut());
            session.setKennelThrough(sessionDto.getKennelThrough());
            session.setKennelIn(sessionDto.getKennelIn());
            session.setShyness(sessionDto.getShyness());
            session.setLeash(sessionDto.getLeash());
            session.setMouthing(sessionDto.getMouthing());
            session.setJumping(sessionDto.getJumping());
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

    public List<Session> findByAnimalID(Long id) {
        Animal animal = animalRepository.getById(id);
        List<Session> sessions = sessionRepository.findAllByAnimal(animal);
        return sessions;
    }
}