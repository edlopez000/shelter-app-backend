package com.shelterapp.backend.repository;

import com.shelterapp.backend.entities.Housekeeping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface HouseRepository extends JpaRepository<Housekeeping, UUID> {
}
