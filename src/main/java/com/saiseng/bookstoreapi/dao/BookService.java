package com.saiseng.bookstoreapi.dao;

import com.saiseng.bookstoreapi.model.Author;
import com.saiseng.bookstoreapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class BookService {

	@Autowired
	BookRepository bookRepo;
	@Autowired
	AuthorRepository authorRepo;

	public Author findAuthorById(Integer id) throws DataAccessException {
		return authorRepo.findById(id).orElse(null);
	}

	public Book findBookById(Integer id) throws DataAccessException {
		return bookRepo.findById(id).orElse(null);
	}

	// search exact match
	public List<Book> findBooksByTitle(String title) throws DataAccessException {
		return bookRepo.findByTitle(title);
	}

	// search exact match
	public List<Book> findBooksByAuthorName(String name) throws DataAccessException {
		return bookRepo.findByAuthor_name(name);
	}

	public List<Book> findAllBooks() throws DataAccessException {
		List<Book> list = new ArrayList<Book>();
		bookRepo.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	public Book addBook(Book book) throws DataAccessException {
		return bookRepo.save(book);
	}

	public Book updateBook(Book book) throws DataAccessException {
		return bookRepo.save(book);
	}

	public void deleteBook(Book book) throws DataAccessException {
		bookRepo.delete(book);
	}
}
