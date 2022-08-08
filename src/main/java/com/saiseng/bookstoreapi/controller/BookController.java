package com.saiseng.bookstoreapi.controller;

import com.saiseng.bookstoreapi.dao.BookService;
import com.saiseng.bookstoreapi.dto.*;
import com.saiseng.bookstoreapi.model.Author;
import com.saiseng.bookstoreapi.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book",
		method = {RequestMethod.POST, RequestMethod.GET})

public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);


	@Autowired
	BookService service;

	@PostMapping(value = "/add")
	public RespNewBook addBook(@RequestBody ReqNewBook req) {
		RespNewBook resp = null;
		logger.info("addBook(): adding new book with ISBN: {}", req.getIsbn());

		// check if authorId is valid
		Author author = service.findAuthorById(req.getAuthorId());
		if (author == null) {
			resp = new RespNewBook(RespNewBook.ERROR, "Invalid authorId");
		} else {
			// map dto to model
			Book book = new Book();
			book.setIsbn(req.getIsbn());
			book.setTitle(req.getTitle());
			book.setAuthor(author);
			book.setYear(req.getYear());
			book.setPrice(req.getPrice());
			book.setGenre(req.getGenre());

			// add book
			try {
				book = service.addBook(book);
				resp = new RespNewBook(RespNewBook.SUCCESS, "Book is added successfully", book.getId());

				logger.info("addBook(): added new book with ID: {}", book.getId());
			} catch (DataAccessException ex) {
				resp = new RespNewBook(RespUpdateBook.ERROR, "Error updating book");
				logger.error("addBook(): error", ex);
			} catch (Exception ex) {
				resp = new RespNewBook(RespUpdateBook.ERROR, "Error updating book");
				logger.error("addBook(): error", ex);
			} finally {
				logger.info("addBook(): END");
			}
		}

		return resp;
	}


	@PutMapping(value = "/update")
	public RespUpdateBook updateBook(@RequestBody ReqUpdateBook req) {
		RespUpdateBook resp = null;
		logger.info("updateBook(): updating bookId: {}", req.getId());

		// check if bookId is valid
		Book book = service.findBookById(req.getId());
		if (book == null) {
			resp = new RespUpdateBook(RespNewBook.ERROR, "Invalid booK ID");
		} else {
			// check if authorId is valid
			Author author = service.findAuthorById(req.getAuthorId());
			if (author == null) {
				resp = new RespUpdateBook(RespNewBook.ERROR, "Invalid author ID");
			} else {
				// map dto to model
				book.setIsbn(req.getIsbn());
				book.setTitle(req.getTitle());
				book.setAuthor(author);
				book.setYear(req.getYear());
				book.setPrice(req.getPrice());
				book.setGenre(req.getGenre());

				// update book
				try {
					service.updateBook(book);
					resp = new RespUpdateBook(RespUpdateBook.SUCCESS, "Book is updated successfully");

					logger.info("updateBook(): updated book with ID: {}", book.getId());
				} catch (DataAccessException ex) {
					resp = new RespUpdateBook(RespUpdateBook.ERROR, "Error updating book");
					logger.error("updateBook(): error", ex);
				} catch (Exception ex) {
					resp = new RespUpdateBook(RespUpdateBook.ERROR, "Error updating book");
					logger.error("updateBook(): error", ex);
				} finally {
					logger.info("updateBook(): END");
				}
			}
		}

		return resp;
	}

	@PostMapping(value = "/find-by-author")
	public RespBookSearch findBooksByAuthor(@RequestBody ReqBookSearch req) {
		RespBookSearch resp = null;
		logger.info("findBooksByAuthor(): search-text: {}", req.getSearchText());

		try {
			List<Book> bookList = service.findBooksByAuthorName(req.getSearchText());
			if (bookList.size() == 0) {
				resp = new RespBookSearch(RespUpdateBook.SUCCESS, "No record is found");
			} else {
				resp = new RespBookSearch(RespUpdateBook.SUCCESS, "Search completed", bookList);
				logger.info("findBooksByAuthor(): total-found: {}", bookList.size());
			}
		} catch (DataAccessException ex) {
			resp = new RespBookSearch(RespUpdateBook.ERROR, "Error searching book");
			logger.error("findBooksByAuthor(): error", ex);
		} catch (Exception ex) {
			resp = new RespBookSearch(RespUpdateBook.ERROR, "Error searching book");
			logger.error("findBooksByAuthor(): error", ex);
		} finally {
			logger.info("findBooksByAuthor(): END");
		}

		return resp;
	}

	@PostMapping(value = "/find-by-title")
	public RespBookSearch findBooksByTitle(@RequestBody ReqBookSearch req) {
		RespBookSearch resp = null;
		logger.info("findBooksByTitle(): search-text: {}", req.getSearchText());


		try {
			List<Book> bookList = service.findBooksByTitle(req.getSearchText());
			if (bookList.size() == 0) {
				resp = new RespBookSearch(RespUpdateBook.SUCCESS, "No record is found");
			} else {
				resp = new RespBookSearch(RespUpdateBook.SUCCESS, "Search completed", bookList);
				logger.info("findBooksByTitle(): total-found: {}", bookList.size());
			}
		} catch (DataAccessException ex) {
			resp = new RespBookSearch(RespUpdateBook.ERROR, "Error searching book");
			logger.error("findBooksByTitle(): error", ex);
		} catch (Exception ex) {
			resp = new RespBookSearch(RespUpdateBook.ERROR, "Error searching book");
			logger.error("findBooksByTitle(): error", ex);
		} finally {
			logger.info("findBooksByTitle(): END");
		}

		return resp;
	}

	@GetMapping(value = "/find-all")
	public RespBookSearch findAllBooks() {
		RespBookSearch resp = null;

		try {
			List<Book> bookList = service.findAllBooks();
			if (bookList.size() == 0) {
				resp = new RespBookSearch(RespUpdateBook.SUCCESS, "No record is found");
			} else {
				resp = new RespBookSearch(RespUpdateBook.SUCCESS, "Search completed", bookList);
				logger.info("findAllBooks(): total-found: {}", bookList.size());
			}
		} catch (DataAccessException ex) {
			resp = new RespBookSearch(RespUpdateBook.ERROR, "Error searching book");
			logger.error("findAllBooks(): error", ex);
		} catch (Exception ex) {
			resp = new RespBookSearch(RespUpdateBook.ERROR, "Error searching book");
			logger.error("findAllBooks(): error", ex);
		} finally {
			logger.info("findAllBooks(): END");
		}

		return resp;
	}



	@PostMapping("/delete")
	public RespDeleteBook deleteBook(@RequestBody ReqDeleteBook req) {
		// only authenticated user can delete, handle under security

		RespDeleteBook resp = null;
		logger.info("deleteBook(): deleting bookId: {}", req.getId());

		// check if bookId is valid
		Book book = service.findBookById(req.getId());
		if (book == null) {
			resp = new RespDeleteBook(RespNewBook.ERROR, "Invalid book ID");
		} else {

			// delete book
			try {
				service.deleteBook(book);
				resp = new RespDeleteBook(RespUpdateBook.SUCCESS, "Book is deleted successfully");
				logger.info("deleteBook(): deleted book");
			} catch (DataAccessException ex) {
				resp = new RespDeleteBook(RespUpdateBook.ERROR, "Error deleting book");
				logger.error("deleteBook(): error", ex);
			} catch (Exception ex) {
				resp = new RespDeleteBook(RespUpdateBook.ERROR, "Error deleting book");
				logger.error("deleteBook(): error", ex);
			} finally {
				logger.info("deleteBook(): END");
			}
		}

		return resp;
	}
}
