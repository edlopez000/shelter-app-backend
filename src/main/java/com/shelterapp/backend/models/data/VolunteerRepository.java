package com.shelterapp.backend.models.data;

import com.shelterapp.backend.models.Volunteer;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
