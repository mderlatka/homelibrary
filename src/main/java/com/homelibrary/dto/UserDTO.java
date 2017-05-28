package com.homelibrary.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {

	@NotEmpty(message = "{userDto.name.validation}")
	@Size(min = 3, message = "{userDto.name.validation2}")
	private String userName;
	@NotEmpty(message = "{userDto.password.validation}")
	@Size(min = 5, message = "{userDto.password.validation2}")
	private String password;
	@NotEmpty(message = "{userDto.email.validation}Pole adresu email nie mo�e by� puste")
	@Email(message = "{userDto.email.validation2}")
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
