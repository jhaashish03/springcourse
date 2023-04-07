package com.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.entities.Book;
import com.springRest.services.BookService;

@RestController
public class BookController {
	@Autowired
	public BookService bookService;

	@GetMapping("/books")
	public List<Book> getBook() {
		return this.bookService.getAllBooks();
	}
	@GetMapping("books/{bId}")
	public Book getById(@PathVariable("bId") int id){
		return this.bookService.getById(id);
	}
	/**
	 * @param book
	 * @return
	 */
	@PostMapping("/listbook")
	public ResponseEntity<Object> listBook(@RequestBody Book book) {

		try {
			 this.bookService.listbook(book);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/up-book/{bid}")
	public ResponseEntity<Book> upBook(@RequestBody Book book, @PathVariable("bid") int bId) {
		try{
		 this.bookService.upBook(book, bId);
		 return ResponseEntity.ok().body(book);
		} catch (Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
		}
	}

	@DeleteMapping("/delete/{id}")
	public String delBook(@PathVariable("id") int bid) {
		this.bookService.delbook(bid);
		return "Record deleted";
	}

	@GetMapping("/hello")
	public String getHelo(){
		return "hello";
	}
}
