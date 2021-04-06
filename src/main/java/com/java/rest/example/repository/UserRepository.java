package com.java.rest.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.rest.example.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
}

