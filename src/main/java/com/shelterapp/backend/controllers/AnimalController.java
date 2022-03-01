package com.shelterapp.backend.controllers;

import com.shelterapp.backend.models.Animal;
import com.shelterapp.backend.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/animals")
@CrossOrigin(origins = "http://localhost:3000")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAnimals() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Long id) {
        return animalService.getAnimal(id);
    }

    @GetMapping("/species/{species}")
    public List<Animal> findBySpecies(@PathVariable String species) {
        return animalService.findBySpecies(species);
    }

    @PostMapping
    public void createAnimal(@RequestBody Animal animal) {
        animalService.save(animal);

    }
}
