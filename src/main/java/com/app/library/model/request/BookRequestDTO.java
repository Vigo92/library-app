package com.app.library.model.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookRequestDTO {

	
	@NotNull(message = "Author cannot be null")
	private String author;

	@NotNull(message = "Title cannot be null")
	private String title;
	
	@NotNull(message = "ISBN cannot be null")
	private String isbn;
	
	@NotNull(message = "Publisher cannot be null")
	private String publisher;
	
	@NotNull(message = "Country cannot be null")
	private String country;
	
	@NotNull(message = "Gender cannot be null")
	private String gender;

}
