package com.springRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springRest.dao.BookRepo;
import com.springRest.entities.Book;

import java.util.*;
@Component
public class BookService {
	@Autowired
private BookRepo bookRepo;

	// private static List<Book> list=new ArrayList<Book>();
	
	// static {
	// 	list.add(new Book(55,"SAmple Paper","Arihant"));
	// 	list.add(new Book(557,"Question Bank","Oswall"));
	// 	list.add(new Book(555,"Guesss paperr","Sharma"));
	// }

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub

		return this.bookRepo.findAll();
	}


	public Book listbook(Book book) {
		// TODO Auto-generated method stub
		Book b=this.bookRepo.save(book);
		return b;
	}

    /**
     * @param book
     * @param bId
     * @return
     */
    public Book upBook(Book book, int bId) {
		Optional<Book> optional=this.bookRepo.findById(bId);
		Book b= optional.get();
		b.setAuthor(book.getAuthor());
		b.setName(book.getName());
		return this.bookRepo.save(b);

    }


	public void delbook(int bid) {
		
		this.bookRepo.deleteById(bid);
	}

	public Book getById(int id) {
		return (this.bookRepo.findById(id)).get();
	}
	
}
