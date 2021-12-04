package com.app.library.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.library.model.request.BookRequestDTO;
import com.app.library.model.request.UpdateBookDTO;
import com.app.library.model.response.BookResponseDTO;
import com.app.library.service.BookService;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	private Logger logger  = Logger.getLogger(BookController.class.getName());
	
	@PostMapping(path = "create", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody final BookRequestDTO bookRequestDTO){
		
		logger.log(Level.INFO, "Create Book request {}"+bookRequestDTO);
		BookResponseDTO bookResponseDTO = bookService.createBook(bookRequestDTO);
		logger.log(Level.INFO, "Create Book response {}"+bookResponseDTO);
		
		return new ResponseEntity<BookResponseDTO>(bookResponseDTO, HttpStatus.OK);

		
	}
	
	@PatchMapping(path = "update", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<BookResponseDTO> updateBook(@Valid @RequestBody final UpdateBookDTO updateBookDTO){
		
		logger.log(Level.INFO, "Update Book request {}"+updateBookDTO);
		BookResponseDTO bookResponseDTO = bookService.updateBook(updateBookDTO);
		logger.log(Level.INFO, "Update Book response {}"+bookResponseDTO);
		
		return new ResponseEntity<BookResponseDTO>(bookResponseDTO, HttpStatus.OK);

		
	}
	
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Long id){
		
		logger.log(Level.INFO, "Delete Book request {}"+id);
		bookService.deleteBook(id);
		logger.log(Level.INFO, " Book deleted response {}");
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		
	}
	
	@GetMapping(path = "book/{id}")
	public ResponseEntity<BookResponseDTO> getBook(@PathVariable("id") Long id){
		
		logger.log(Level.INFO, "GET Book request {}"+id);
		BookResponseDTO bookResponseDTO = bookService.getBook(id);
		logger.log(Level.INFO, " get Book response {}"+bookResponseDTO);
		
		return new ResponseEntity<>(bookResponseDTO, HttpStatus.OK);

		
	}
	
	@GetMapping(path = "all")
	public ResponseEntity<List<BookResponseDTO>> getBooks(){
		
		logger.log(Level.INFO, "GET Books request {}");
		List<BookResponseDTO> bookResponseDTO = bookService.getBooks();
		logger.log(Level.INFO, "get Book  response {}"+bookResponseDTO);
		
		return new ResponseEntity<>(bookResponseDTO, HttpStatus.OK);

		
	}
	
	

	
}
