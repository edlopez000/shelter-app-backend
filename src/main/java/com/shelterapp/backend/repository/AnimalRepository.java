package com.shelterapp.backend.repository;

import com.shelterapp.backend.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface AnimalRepository extends JpaRepository<Animal, UUID> {
    List<Animal> findBySpecies(String species);
}
