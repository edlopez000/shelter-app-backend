package com.shelterapp.backend.controllers;

//import com.shelterapp.backend.service.SessionService;
import com.shelterapp.backend.dto.SessionDto;
        import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {

//    private final SessionService sessionService;

//    @Autowired
//    public SessionController(SessionService sessionService) {
//        this.sessionService = sessionService;
//    }
//
//    @GetMapping
//    public List<Session> getSessions() {
////        return sessionService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Session getSession(@PathVariable Long id) {
////        return sessionService.getSession(id);
//    }

    @PostMapping
    public void createSession(@RequestBody SessionDto sessionDTO) {
//        sessionService.save(session);

    }
}
