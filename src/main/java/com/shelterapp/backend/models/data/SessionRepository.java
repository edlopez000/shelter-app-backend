package com.shelterapp.backend.models.data;

import com.shelterapp.backend.models.Animal;
import com.shelterapp.backend.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface SessionRepository extends JpaRepository<Session, Long> {

    ArrayList<Session> findAllByAnimal(Animal animal);
}
