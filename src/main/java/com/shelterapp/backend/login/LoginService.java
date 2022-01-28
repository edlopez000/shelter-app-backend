package com.shelterapp.backend.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public Login login(String username, String password){
		return loginRepository.findByUserNameAndPassword(username, password);
	}

}
