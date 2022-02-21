package com.shelterapp.backend.controllers;

import com.shelterapp.backend.models.Animal;
import com.shelterapp.backend.models.data.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/animals")
    public class AnimalController {

        @Autowired
        private AnimalRepository animalRepository;

        @PostMapping
        public void createAnimal(@RequestBody Animal animal) {
            animalRepository.save(animal);

        }
    }
