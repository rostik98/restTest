package com.java.rest.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.rest.example.entity.Book;
import com.java.rest.example.entity.User;
import com.java.rest.example.service.BookService;
import com.java.rest.example.service.UserService;

@RestController
public class Controller {

	@Autowired
	private UserService uservice;
	@Autowired
	private BookService bservice;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {

		return uservice.saveUser(user);
	}

	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {

		return bservice.saveBook(book);
	}

	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books) {

		return bservice.saveBooks(books);
	}

	@PutMapping("/takeBook/{uid}/{bid}")
	public Book takeBook(@PathVariable("uid") int uid, @PathVariable("bid") int bid) {

		return bservice.updateBook(uid, bid);
	}

	@PutMapping("/returnBook/{uid}/{bid}")
	public Book returnBook(@PathVariable("uid") int uid, @PathVariable("bid") int bid) {

		return bservice.returnBook(uid, bid);
	}

	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return uservice.saveUsers(users);
	}

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return uservice.getUsers();
	}

	@GetMapping("/info")
	public Map<User, List<Object>> info() {
		Map<User, List<Object>> map = new HashMap<>();
		List<Book> books = bservice.getBooks();
		for (Book book : books) {
			if (book.getUser() != null) {
				if (!map.containsKey(book.getUser())) {
					List<Object> l = new ArrayList<Object>();
					l.add(book.toString());
					map.put(book.getUser(), l);
				} else {
					map.get(book.getUser()).add(book.toString());
				}
			}
		}
		return map;
	}

	@GetMapping("/books")
	public List<Book> findAllBooks() {
		return bservice.getBooks();
	}

	@GetMapping("/findUserById/{id}")
	public User findUserById(@PathVariable("id") int id) {
		return uservice.getUserById(id);
	}

	@GetMapping("/findBookById/{id}")
	public Book findBookById(@PathVariable("id") int id) {
		return bservice.getBookById(id);
	}

	@PutMapping("/updateById/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		return uservice.updateUser(id, user);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		uservice.deleteUser(id);
	}

	@PutMapping("/updateBookById/{id}")
	public Book updateUBook(@PathVariable("id") int id, @RequestBody User user) {
		return bservice.updateBook(user.getId(), id);
	}

	@DeleteMapping("/deleteBookById/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		bservice.deleteBook(id);
	}
}
