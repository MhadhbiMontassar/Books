package com.montassar.books.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.montassar.books.entities.Book;
import com.montassar.books.entities.Categorie;


@RepositoryRestResource(path = "rest")
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByNomBook(String nom);
	List<Book> findByNomBookContains(String nom);

	
	/*@Query
	("select p from Book p where p.nomBook like %?1 and p.prixBook > ?2")
	List<Book> findByNomPrix (String nom, Double prix);*/

	@Query("select p from Book p where p.nomBook like %:nom and p.prixBook > :prix")
	List<Book> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	@Query("select p from Book p where p.categorie = ?1")
	List<Book> findByCategorie (Categorie categorie);
	
	List<Book> findByCategorieIdCat(Long id);
	
	List<Book> findByOrderByNomBookAsc();
	
	@Query("select p from Book p order by p.nomBook ASC, p.prixBook DESC")
	List<Book> trierBooksNomsPrix ();



}
