package com.springRest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private String loc;
@OneToOne(mappedBy = "author")
@JsonBackReference
private Book book;

public Author(int id, String name, String loc, Book book) {
    this.id = id;
    this.name = name;
    this.loc = loc;
    this.book = book;
}



public Author() {
}



public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getLoc() {
    return loc;
}

public void setLoc(String loc) {
    this.loc = loc;
}

@Override
public String toString() {
    return "Author [id=" + id + ", name=" + name + ", loc=" + loc + "]";
}

public Book getBook() {
    return book;
}

public void setBook(Book book) {
    this.book = book;
}

}
