package com.shelterapp.backend.models.data;

import com.shelterapp.backend.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    public List<Animal> findBySpecies(String species);
}
