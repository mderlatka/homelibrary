package com.homelibrary.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.homelibrary.domain.Author;
import com.homelibrary.domain.Category;

public class BookDTO {

	@NotEmpty(message = "{bookDto.title.validation}")
	private String title;
	@NotNull(message = "{bookDto.author.validation}")
	private Author author;
	@NotEmpty(message = "{bookDto.releaseDate.validation1}")
	@Pattern(regexp = "[0-3][0-9]\\.[0-1][0-9]\\.[1-2][0-9]{3}", message = "{bookDto.releaseDate.validation2}")
	private String releaseDate;
	@NotNull(message = "{bookDto.category.validation}")
	private Category category;
	@Min(value = 1, message = "{bookDto.numOfPages.validation3}")
	@Digits(fraction = 0, integer = 4, message = "{bookDto.numOfPages.validation2}")
	@NotNull(message = "{bookDto.numOfPages.validation}")
	private Integer numOfPages;
	@Size(min = 10, max = 2000, message = "{bookDto.description.validation}")
	private String description;
	
	private MultipartFile bookImage;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}

	public void setNumOfPages(Integer numOfPages) {
		this.numOfPages = numOfPages;
	}

	public Integer getNumOfPages() {
		return numOfPages;
	}
}
