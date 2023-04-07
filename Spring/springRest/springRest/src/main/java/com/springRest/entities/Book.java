package com.springRest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="book_info")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bid;
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
	public Book() {
	}
	public Book(int bid, String name, Author author) {
		this.bid = bid;
		this.name = name;
		this.author = author;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", author=" + author + "]";
	}
	
	
	
	
}
