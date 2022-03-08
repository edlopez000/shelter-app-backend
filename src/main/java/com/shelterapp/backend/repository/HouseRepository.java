package com.shelterapp.backend.repository;

import com.shelterapp.backend.entity.Housekeeping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface HouseRepository extends JpaRepository<Housekeeping, UUID> {

    Optional<List<Housekeeping>> findHouseByVolunteerId(UUID id);
}
