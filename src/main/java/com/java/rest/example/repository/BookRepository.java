package com.java.rest.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.rest.example.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
