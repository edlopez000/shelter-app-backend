package com.shelterapp.backend.login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Long, Login> {

	Login findByUserNameAndPassword(String username, String password);
}
