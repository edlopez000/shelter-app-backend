package com.shelterapp.backend.controllers;

import com.shelterapp.backend.entity.Animal;
import com.shelterapp.backend.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/animals")
@CrossOrigin(origins = "http://localhost:3000")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> getAnimals() {
        System.out.println(LocalDateTime.now());
        return animalService.findAll();
    }

    @GetMapping("/{id}")
     public Animal getAnimal(@PathVariable UUID id) {
        return animalService.getAnimal(id);
    }

    @GetMapping("/species/{species}")
    public ResponseEntity<List<Animal>> findBySpecies(@PathVariable String species) {
        return animalService.findBySpecies(species);
    }

    @PostMapping
    public void createAnimal(@RequestBody Animal animal) {
        animalService.save(animal);
    }
}
