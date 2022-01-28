package com.shelterapp.backend.login;

import javax.persistence.*;

//https://www.youtube.com/watch?v=DrKA56M1NRs&t=3s

@Entity
@Table(name="login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String password;

	public Login() {
	}

	public Login(long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
