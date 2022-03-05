package com.shelterapp.backend.repository;

import com.shelterapp.backend.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    public List<Animal> findBySpecies(String species);
}
