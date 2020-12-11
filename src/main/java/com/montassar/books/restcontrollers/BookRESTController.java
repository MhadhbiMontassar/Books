package com.montassar.books.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montassar.books.entities.Book;
import com.montassar.books.service.BookService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookRESTController {
	@Autowired
	BookService bookService;
	
	@RequestMapping(method=RequestMethod.GET)
	 public List<Book> getAllBooks()
	{
		return bookService.getAllBooks();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Book getBookById(@PathVariable("id") Long id) {
	return bookService.getBook(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
	return bookService.saveBook(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Book updateBook(@RequestBody Book book) {
	return bookService.updateBook(book);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") Long id)
	{
	bookService.deleteBookById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Book> getBooksByCatId(@PathVariable("idCat") Long idCat) {
	return bookService.findByCategorieIdCat(idCat);
	}
}
