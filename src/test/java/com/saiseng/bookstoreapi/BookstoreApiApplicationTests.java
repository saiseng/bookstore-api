package com.saiseng.bookstoreapi;

import com.saiseng.bookstoreapi.controller.BookController;
import com.saiseng.bookstoreapi.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookstoreApiApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(BookstoreApiApplicationTests.class);

	@Autowired
	BookController ctrl = new BookController();

	@Test
	void contextLoads() {
	}

	@Test
	public void testBookController() {

		// TODO: invoke using RestTemplate
		ReqBookSearch search = new ReqBookSearch();
		RespBookSearch resp = null;

		// verify search by author name
		search.setSearchText("Godin, Seth");
		resp = ctrl.findBooksByAuthor(search);
		Assertions.assertEquals(resp.getBooks().get(0).getAuthor().getId(), 12);

		// verify search by title
		search.setSearchText("Startup");
		resp = ctrl.findBooksByTitle(search);
		Assertions.assertEquals(resp.getBooks().get(0).getAuthor().getId(), 58);

		// verify add
		ReqNewBook newBook = new ReqNewBook();
		newBook.setAuthorId(12);
		newBook.setGenre("new-cat");
		newBook.setIsbn("1234567890");
		newBook.setPrice(new BigDecimal(99.99));
		newBook.setTitle("Unit Testing Data");
		newBook.setYear(2022);
		RespNewBook respNB = ctrl.addBook(newBook);
		assertEquals(respNB.getStatus(), RespNewBook.SUCCESS);

		// verify update
		ReqUpdateBook updBook = new ReqUpdateBook();
		updBook.setId(respNB.getBookId());
		updBook.setAuthorId(12);
		updBook.setGenre("new-cat");
		updBook.setIsbn("1234567890");
		updBook.setPrice(new BigDecimal(99.99));
		updBook.setTitle("Unit Testing Data UPD");
		updBook.setYear(2021);
		RespUpdateBook respUB = ctrl.updateBook(updBook);
		assertEquals(respUB.getStatus(), RespUpdateBook.SUCCESS);

		// verify delete
		ReqDeleteBook delBook = new ReqDeleteBook();
		delBook.setId(respNB.getBookId());
		RespDeleteBook respDB = ctrl.deleteBook(delBook);
		assertEquals(respDB.getStatus(), RespDeleteBook.SUCCESS);
	}
}
