package com.homelibrary.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class AuthorDTO {

	@NotEmpty(message = "{authorDto.firstname.vaidation}")
	private String authorName;
	@NotEmpty(message = "{authorDto.surname.vaidation}")
	private String authorSurname;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}
}
