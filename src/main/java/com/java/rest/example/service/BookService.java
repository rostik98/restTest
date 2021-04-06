package com.java.rest.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.rest.example.entity.Book;
import com.java.rest.example.entity.User;
import com.java.rest.example.repository.BookRepository;
import com.java.rest.example.repository.UserRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	@Autowired
	private UserRepository urepository;

	public Book saveBook(Book book) {
		return repository.save(book);
	}

	public List<Book> saveBooks(List<Book> books) {
		return repository.saveAll(books);
	}

	public List<Book> getBooks() {
		return repository.findAll();
	}

	public Book getBookById(int id) {
		return repository.findById(id).orElse(null);
	}

	public void deleteBook(int id) {
		repository.deleteById(id);
	}

	public Book updateBook(int uid, int bid) {
		User existingUser = urepository.findById(uid).orElse(null);
		Book existingBook = repository.findById(bid).orElse(null);
		if (existingBook.isFree()) {

			existingBook.setUser(existingUser);
			existingBook.setFree(false);
			return repository.save(existingBook);
		} else
			return null;
	}

	public Book returnBook(int uid, int bid) {
		User existingUser = urepository.findById(uid).orElse(null);
		Book existingBook = repository.findById(bid).orElse(null);
		if (existingUser != null) {
			if (!existingBook.isFree()) {

				existingBook.setUser(null);
				existingBook.setFree(true);
				return repository.save(existingBook);
			} else
				return null;
		} else
			return null;
	}
}
