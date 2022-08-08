package com.saiseng.bookstoreapi.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Table(name = "book")
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(max = 255)
	private String isbn;
	@Size(max = 255)
	private String title;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;

	private Integer year;
	private BigDecimal price;
	@Size(max = 255)
	private String genre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
