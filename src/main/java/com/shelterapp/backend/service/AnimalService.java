package com.shelterapp.backend.service;

import com.shelterapp.backend.models.Animal;
import com.shelterapp.backend.models.data.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) { this.animalRepository = animalRepository;}

    public Animal getAnimal(Long id) {return animalRepository.findById(id).orElseThrow(RuntimeException::new);}

    public void registerNewAnimal(Animal animal) {animalRepository.save(animal);}

    public List<Animal> findAll() {return animalRepository.findAll();}

    public List<Animal> findBySpecies(String species) {return animalRepository.findBySpecies(species);}
}
