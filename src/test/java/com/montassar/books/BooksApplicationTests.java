package com.montassar.books;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.montassar.books.entities.Book;
import com.montassar.books.entities.Categorie;
import com.montassar.books.repos.BookRepository;
import com.montassar.books.service.BookService;

@SpringBootTest
class BooksApplicationTests {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;
	@Test
	public void testCreateBook() {
		Book prod = new Book("Learn HTML",22.500,new Date());
		bookRepository.save(prod);
         }
	
	@Test
	public void testFindBook() {
	Book p = bookRepository.findById(2L).get();
	System.out.println(p);
}
	@Test
	public void testUpdateBook() {
	Book p = bookRepository.findById(2L).get();
	p.setPrixBook(26.500);
	bookRepository.save(p);
	}
	
	@Test
	public void testDelateBook() {
		bookRepository.deleteById(2l);
	}
	
	@Test
	public void testListerTousBooks() {
		List<Book> books = bookRepository.findAll();
		for (Book p : books)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByNomBookContains()
	{
	Page<Book> prods = bookService.getAllBooksParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	
	@Test
	public void testFindBookByNom() {
	List <Book> prods = bookRepository.findByNomBook("learn JEE");
	for (Book p : prods)
	{
		System.out.println(p);
	}
	}
	
	
	@Test
	public void testFindBookByNomContains() {
	List <Book> prods = bookRepository.findByNomBookContains("l");
	for (Book p : prods)
	{
		System.out.println(p);
	}
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Book> prods = bookRepository.findByNomPrix("learn Java", 9.0);
	for (Book p : prods)
	{
	System.out.println(p);
	}
	}
	
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Book> prods = bookRepository.findByCategorie(cat);
	for (Book p : prods)
	{
	System.out.println(p);
	}
}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Book> prods = bookRepository.findByCategorieIdCat(1L);
	for (Book p : prods)
	{
	System.out.println(p);
	}
	 }
	
	@Test
	public void testfindByOrderByNomBookAsc()
	{
	List<Book> prods = bookRepository.findByOrderByNomBookAsc();
	for (Book p : prods)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testTrierBooksNomsPrix()
	{
	List<Book> prods = bookRepository.trierBooksNomsPrix();
	for (Book p : prods)
	{
	System.out.println(p);
	}
	}
}