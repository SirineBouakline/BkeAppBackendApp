package com.bke.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String telephoneNumberr;

	public Employee() {
	}

	public Employee(long id, String firstName, String lastName, String telephoneNumberr) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumberr = telephoneNumberr;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getTelephoneNumberr() {
		return telephoneNumberr;
	}

	public void setTelephoneNumberr(String telephoneNumberr) {
		this.telephoneNumberr = telephoneNumberr;
	}

}
