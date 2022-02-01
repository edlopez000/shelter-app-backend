package com.shelterapp.backend.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

	private final LoginRepository loginRepository;

	@Autowired
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public Login getLogin(Long id) {
		return loginRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public void registerNewLogin(Login login) {
		loginRepository.save(login);
	}

	public List<Login> findAll() {
		return loginRepository.findAll();
	}
}
