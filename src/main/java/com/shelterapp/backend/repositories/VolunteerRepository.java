package com.shelterapp.backend.repositories;

import com.shelterapp.backend.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
