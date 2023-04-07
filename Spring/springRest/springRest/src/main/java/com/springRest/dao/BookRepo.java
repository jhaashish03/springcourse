package com.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springRest.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{
    
}
