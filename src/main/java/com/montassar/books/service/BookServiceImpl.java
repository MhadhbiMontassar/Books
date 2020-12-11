package com.montassar.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.montassar.books.entities.Book;
import com.montassar.books.entities.Categorie;
import com.montassar.books.repos.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	@Override
	public Book saveBook(Book p) {
		return bookRepository.save(p);
	}

	@Override
	public Book updateBook(Book p) {
		return bookRepository.save(p);
	}

	@Override
	public void deleteBook(Book p) {
		bookRepository.delete(p);
	}

	@Override
	public void deleteBookById(long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Book getBook(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Page<Book> getAllBooksParPage(int page, int size) {
	
		return bookRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Book> findByNomBook(String nom) {
		
		return bookRepository.findByNomBook(nom);
	}

	@Override
	public List<Book> findByNomBookContains(String nom) {
		
		return bookRepository.findByNomBookContains(nom);
	}

	@Override
	public List<Book> findByNomPrix(String nom, Double prix) {
		
		return bookRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Book> findByCategorie(Categorie categorie) {
		
		return bookRepository.findByCategorie(categorie);
	}

	@Override
	public List<Book> findByCategorieIdCat(Long id) {
		
		return bookRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Book> findByOrderByNomBookAsc() {
		
		return bookRepository.findByOrderByNomBookAsc();
	}

	@Override
	public List<Book> trierBooksNomsPrix() {
		
		return bookRepository.trierBooksNomsPrix();
	}
	



}
