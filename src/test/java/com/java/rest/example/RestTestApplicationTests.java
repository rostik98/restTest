package com.java.rest.example;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.rest.example.entity.User;
import com.java.rest.example.repository.BookRepository;
import com.java.rest.example.repository.UserRepository;
import com.java.rest.example.service.BookService;
import com.java.rest.example.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.java.rest.example")
class RestTestApplicationTests {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {

		assertTrue(userService.getUsers().isEmpty());
	}

	@Test
	void contextLoads1() {
		User user = new User();
		user.setId(1);
		user.setName("ivan");
		userService.saveUser(user);
		assertTrue(userService.getUsers().get(0).equals(user));
	}

}
