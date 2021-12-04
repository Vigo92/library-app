package com.app.library.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
public class Book {
	
	
	@SequenceGenerator(name="library_seq", sequenceName = "library_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "library_seq")
	@Id
	private Long id;
	
	private String author;
	
	private String title;
	
	private String isbn;
	
	private String publisher;
	
	private String country;
	
	private String gender;

}        