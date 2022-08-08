package com.saiseng.bookstoreapi.dto;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ReqNewBook {


	@NotBlank(message = "ISBN is mandatory")
	private String isbn;
	@NotBlank(message = "Title is mandatory")
	private String title;
	@NotBlank(message = "Author is mandatory")

	private Integer authorId;
	@NotBlank(message = "Year is mandatory")

	private Integer year;
	@NotBlank(message = "Price is mandatory")

	private BigDecimal price;
	@NotBlank(message = "Genre is mandatory")
	private String genre;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
