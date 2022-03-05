package com.shelterapp.backend.controllers;

import com.shelterapp.backend.entities.Animal;
import com.shelterapp.backend.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {this.animalService = animalService;}

    @PostMapping
    public void createAnimal(@RequestBody Animal animal) {
        animalService.registerNewAnimal(animal);
    }

    @GetMapping
    public List<Animal> getAnimals() {return animalService.findAll();}

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Long id) {return animalService.getAnimal(id);}

    @GetMapping("/species/{species}")
    public List<Animal> findBySpecies(@PathVariable String species) {
        return animalService.findBySpecies(species);
    }

}
