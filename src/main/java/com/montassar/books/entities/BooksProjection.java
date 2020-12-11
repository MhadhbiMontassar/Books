package com.montassar.books.entities;

import org.springframework.data.rest.core.config.Projection;

public interface BooksProjection {
	
	@Projection(name = "nomBookk", types = { Book.class })
	public interface BookProjection {
	public String getNomBook();

	}
}
