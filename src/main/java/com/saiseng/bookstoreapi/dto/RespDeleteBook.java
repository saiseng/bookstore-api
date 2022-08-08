package com.saiseng.bookstoreapi.dto;

public class RespDeleteBook extends RespBase {

	public RespDeleteBook (String status, String message) {
		setStatus(status);
		setMessage(message);
	}
}
