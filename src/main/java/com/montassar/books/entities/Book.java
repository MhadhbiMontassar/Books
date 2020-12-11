package com.montassar.books.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBook;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomBook;
	
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixBook;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;
	
	
	public Book() {
		super();
	}
	
	
	
	public Book(String nomBook, Double prixBook, Date dateCreation) {
		super();
		this.nomBook = nomBook;
		this.prixBook = prixBook;
		this.dateCreation = dateCreation;
	}



	public Long getIdBook() {
		return idBook;
	}
	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}
	public String getNomBook() {
		return nomBook;
	}
	public void setNomBook(String nomBook) {
		this.nomBook = nomBook;
	}
	public Double getPrixBook() {
		return prixBook;
	}
	public void setPrixBook(Double prixBook) {
		this.prixBook = prixBook;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}



	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", nomBook=" + nomBook + ", prixBook=" + prixBook + ", dateCreation="
				+ dateCreation + "]";
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	
}
