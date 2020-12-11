package com.montassar.books;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.montassar.books.entities.Book;
import com.montassar.books.service.BookService;

@SpringBootApplication
public class BooksApplication implements CommandLineRunner  {
	
	@Autowired
	BookService bookService;
	//@Autowired
	//private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//repositoryRestConfiguration.exposeIdsFor(Book.class);
		bookService.saveBook(new Book("learn excel", 26.0, new Date()));
		bookService.saveBook(new Book("learn JEE", 28.0, new Date()));
		bookService.saveBook(new Book("learn python", 12.0, new Date()));
		
	}

}
