package com.shelterapp.backend.controllers;

import com.shelterapp.backend.entities.Session;
import com.shelterapp.backend.service.SessionService;
import com.shelterapp.backend.dto.SessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {

    @Autowired
    private SessionService sessionService;



    @PostMapping
    public ResponseEntity createSession(@RequestBody SessionDto sessionDto) {
        return sessionService.saveSessionData(sessionDto);
    }

    @GetMapping
    public List<Session> getAllSessions() {return sessionService.findAll();}

//    @GetMapping("/{id}")
//    public List<Session> getSessions(@PathVariable Long id) {
//        System.out.println("we are here");
//        return sessionService.findByAnimalId(id);
//
//    }

}
