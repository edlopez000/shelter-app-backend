package com.shelterapp.backend.models.data;

import com.shelterapp.backend.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
