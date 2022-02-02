package com.shelterapp.backend.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService userService;

    @Autowired
    public LoginController(LoginService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Login> getLogins() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Login getLogin(@PathVariable Long id) {
        return userService.getLogin(id);
    }

    @PostMapping
    public void registerNewLogin(@RequestBody Login login) {
        userService.registerNewLogin(login);
    }

}
