package com.montassar.books.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.montassar.books.entities.Book;
import com.montassar.books.entities.Categorie;

public interface BookService {
	
	Book saveBook(Book p);
	Book updateBook(Book p);
	void deleteBook(Book p);
	void deleteBookById(long id);
	Book getBook(Long id);
	List<Book> getAllBooks();
	List<Book> findByNomBook(String nom);
	List<Book> findByNomBookContains(String nom);
	List<Book> findByNomPrix (String nom, Double prix);
	List<Book> findByCategorie (Categorie categorie);
	List<Book> findByCategorieIdCat(Long id);
	List<Book> findByOrderByNomBookAsc();
	List<Book> trierBooksNomsPrix();
	Page<Book> getAllBooksParPage(int page, int size);
	
	
	

}
