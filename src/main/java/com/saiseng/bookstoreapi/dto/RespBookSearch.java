package com.saiseng.bookstoreapi.dto;

import com.saiseng.bookstoreapi.model.Book;

import java.util.List;

public class RespBookSearch extends RespBase {

	private List<Book> books;

	public RespBookSearch (String status, String message) {
		setStatus(status);
		setMessage(message);
	}

	public RespBookSearch (String status, String message, List<Book> list) {
		setStatus(status);
		setMessage(message);
		setBooks(list);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
