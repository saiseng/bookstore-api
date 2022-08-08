package com.saiseng.bookstoreapi.dto;

public class RespUpdateBook extends RespBase {

	public RespUpdateBook (String status, String message) {
		setStatus(status);
		setMessage(message);
	}
}
