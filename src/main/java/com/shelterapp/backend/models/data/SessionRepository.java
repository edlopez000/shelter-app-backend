package com.shelterapp.backend.models.data;

import com.shelterapp.backend.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SessionRepository extends JpaRepository<Session, Long> {
}
