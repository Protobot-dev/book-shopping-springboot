package com.eneromongo.date.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eneromongo.date.model.Book;
import com.eneromongo.date.repository.IBookRepository;

@RestController
public class BookController {

	@Autowired
	private IBookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book){
		bookRepository.save(book);
		return "Added book with id " + book.getId();
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBookById(@PathVariable int id){
		return bookRepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		bookRepository.deleteById(id);
		return "book deleted with id " + id;
	}
	
}
