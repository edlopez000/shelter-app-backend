package com.shelterapp.backend.models.data;

import com.shelterapp.backend.models.Volunteer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VolunteerRepository extends CrudRepository<Volunteer, Long> {
}
