package com.booking.hotel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer", schema = "shivam",
		uniqueConstraints = @UniqueConstraint(columnNames= {"email"}))
public class CustomerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6517403645560177106L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "firstname", nullable=false)
	private String firstName;

	@Column(name = "lastname", nullable=false)
	private String lastName;

	@Column(name = "dob", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	@Email
	@Column(name = "email", unique = true, nullable=false)
	private String email;

	@Size(min = 8, max = 10)
	@Min(8)
	@Max(10)
	@Column(name = "password", nullable=false, length=10)
	private String password;

	public CustomerEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
