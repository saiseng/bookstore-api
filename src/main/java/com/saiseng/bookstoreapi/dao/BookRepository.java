package com.saiseng.bookstoreapi.dao;

import com.saiseng.bookstoreapi.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

	List<Book> findByTitle(String title);

	List<Book> findByAuthor_name(String name);
}
