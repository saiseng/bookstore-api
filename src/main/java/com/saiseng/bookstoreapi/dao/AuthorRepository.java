package com.saiseng.bookstoreapi.dao;

import com.saiseng.bookstoreapi.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository  extends CrudRepository<Author, Integer> {

}
