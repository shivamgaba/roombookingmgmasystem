package com.booking.hotel.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "firstname", "lastname", "dob", "email", "password"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5212396240256621441L;

	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="firstname")
	private String firstName;
	
	@JsonProperty(value="lastname")
	private String lastName;
	
	@JsonProperty(value="dob")
	private Date dob;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="password")
	private String password;
	
	private Customer() {} 
	
	private Customer(CustomerBuilder customerBuilder) {
		this.id = customerBuilder.id;
		this.firstName = customerBuilder.firstName;
		this.lastName = customerBuilder.lastName;
		this.dob = customerBuilder.dob;
		this.email = customerBuilder.email;
		this.password = customerBuilder.password;
	}
	
	public Long getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public Date getDob() { return dob; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	
	public static class CustomerBuilder {

		@JsonProperty(value="id")
		private Long id;
		
		@JsonProperty(value="firstname")
		private String firstName;
		
		@JsonProperty(value="lastname")
		private String lastName;
		
		@JsonProperty(value="dob")
		private Date dob;
		
		@JsonProperty(value="email")
		private String email;
		
		@JsonProperty(value="password")
		private String password;

		public CustomerBuilder() {}
		
		public CustomerBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		
		public CustomerBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public CustomerBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public CustomerBuilder setDob(Date dob) {
			this.dob = dob;
			return this;
		}
		
		public CustomerBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public CustomerBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public Customer build() {
			return new Customer(this);
		}
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(final Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
