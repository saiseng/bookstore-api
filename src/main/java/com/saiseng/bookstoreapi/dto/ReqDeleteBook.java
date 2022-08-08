package com.saiseng.bookstoreapi.dto;

import javax.validation.constraints.NotBlank;

public class ReqDeleteBook {

	@NotBlank(message = "Book ID is mandatory")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
