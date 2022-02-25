package com.shelterapp.backend.models.data;

import com.shelterapp.backend.models.VolunteerHours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VolunteerHoursRepository extends CrudRepository<VolunteerHours, Long> {
}
