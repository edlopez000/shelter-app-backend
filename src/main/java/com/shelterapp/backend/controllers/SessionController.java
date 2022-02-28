package com.shelterapp.backend.controllers;

import com.shelterapp.backend.models.Session;
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


    public ResponseEntity createSession(@RequestBody SessionDto sessionDTO) {
        return sessionService.saveSessionData(sessionDTO);
    }

}
