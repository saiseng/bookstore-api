package com.saiseng.bookstoreapi.dto;

public class RespBase {
	public static final String SUCCESS = "Success";
	public static final String ERROR = "Error";

	private String status = ""; // success, error
	private String message = "";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
