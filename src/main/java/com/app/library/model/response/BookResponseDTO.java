package com.app.library.model.response;

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
@Builder
public class BookResponseDTO {

	private Long id;
	
	private String author;

	private String title;

	private String isbn;

	private String publisher;

	private String country;

	private String gender;

}
