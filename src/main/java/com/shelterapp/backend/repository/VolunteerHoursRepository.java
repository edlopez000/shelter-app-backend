package com.shelterapp.backend.repository;

import com.shelterapp.backend.entities.VolunteerHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VolunteerHoursRepository extends JpaRepository<VolunteerHours, Long> {
}
