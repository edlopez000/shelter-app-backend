package com.shelterapp.backend.users;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return usersRepository.findById(id).orElseThrow(RuntimeException::new);
    }

	@PostMapping
	public void registerNewVolunteer(@RequestBody User user) {
		usersRepository.save(user);
	}

}
