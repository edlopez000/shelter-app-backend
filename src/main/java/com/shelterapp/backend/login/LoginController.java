package com.shelterapp.backend.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginRepository loginRepository;
    
    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping
    public List<Login> getLogin() {
        return loginRepository.findAll();
    }

    @GetMapping("/{id}")
    public Login getUser(@PathVariable Long id) {
        return loginRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
