package com.shelterapp.backend.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

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

	private LocalDate dob;

	@Transient
	private Integer age;

	public Volunteer() {
	}

	public Volunteer(Long id, String firstName, String lastName, String email, LocalDate dob, Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}

	public Volunteer(String firstName, String lastName, String email, LocalDate dob, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.age = age;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Volunteer{" +
		       "id=" + id +
		       ", firstName='" + firstName + '\'' +
		       ", lastName='" + lastName + '\'' +
		       ", email='" + email + '\'' +
		       ", dob=" + dob +
		       ", age='" + age + '\'' +
		       '}';
	}
}