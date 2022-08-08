package com.saiseng.bookstoreapi.dto;

import javax.validation.constraints.NotBlank;

public class ReqBookSearch {

	@NotBlank(message = "Search text is mandatory")
	private String searchText;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
}
