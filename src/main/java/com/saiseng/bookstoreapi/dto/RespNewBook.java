package com.saiseng.bookstoreapi.dto;

public class RespNewBook extends RespBase {

	private Integer bookId;

	public RespNewBook (String status, String message) {
		setStatus(status);
		setMessage(message);
	}
	public RespNewBook (String status, String message, Integer bookId) {
		setStatus(status);
		setMessage(message);
		setBookId(bookId);
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
}
