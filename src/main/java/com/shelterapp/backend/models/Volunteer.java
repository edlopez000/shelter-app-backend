package com.shelterapp.backend.models;

import javax.persistence.*;

@Entity
@Table
public class Volunteer {

	@Id
	@SequenceGenerator(name = "user_id", allocationSize = 1)
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	public Volunteer() {
	}

	public Volunteer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Volunteer(Long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Volunteer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Volunteer{" +
		       "id=" + id +
		       ", firstName='" + firstName + '\'' +
		       ", lastName='" + lastName + '\'' +
		       ", email='" + email + '\'' +
		       '}';
	}
}