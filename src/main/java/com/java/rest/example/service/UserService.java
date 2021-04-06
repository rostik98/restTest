package com.java.rest.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.rest.example.entity.User;
import com.java.rest.example.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public List<User> saveUsers(List<User> users) {
		return repository.saveAll(users);
	}

	public List<User> getUsers() {
		return repository.findAll();
	}

	public User getUserById(int id) {
		return repository.findById(id).orElse(null);
	}

	public User getUserByName(String name) {
		return repository.findByName(name);
	}

	public void deleteUser(int id) {
		repository.deleteById(id);

	}

	public User updateUser(int id, User user) {
		User exUser = repository.findById(id).orElse(null);
		exUser.setName(user.getName());
		return repository.save(exUser);
	}

}
