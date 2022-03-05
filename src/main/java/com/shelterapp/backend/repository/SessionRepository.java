package com.shelterapp.backend.repository;

import com.shelterapp.backend.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<List<Session>> findSessionsByAnimalId(UUID id);
};
