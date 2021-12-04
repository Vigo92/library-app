package com.app.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.library.model.entity.Book;
import com.app.library.model.request.BookRequestDTO;
import com.app.library.model.request.UpdateBookDTO;
import com.app.library.model.response.BookResponseDTO;
import com.app.library.repository.BookRepository;

@Service
public class BookService {
	
	
	@Autowired
	private BookRepository bookRepository;
	
	
	private Logger logger = Logger.getLogger(BookService.class.getName());
	
	
	public List<BookResponseDTO> getBooks(){
		List<BookResponseDTO> response = new ArrayList<>();

		try {
		List<Book> books = bookRepository.findAll();
		books.forEach(book -> {
			BookResponseDTO bookResponseDTO = BookResponseDTO.builder()
					.id(book.getId()).author(book.getAuthor()).country(book.getCountry())
					.gender(book.getGender()).isbn(book.getIsbn()).publisher(book.getPublisher())
					.title(book.getTitle()).build();
			response.add(bookResponseDTO);
		});
		}
		catch(Exception exception) {
		logger.log(Level.SEVERE,exception.getMessage());	
		}
		return response;
	}
	
	public BookResponseDTO getBook(Long id){
		BookResponseDTO bookResponseDTO = null;
		try {
		Book book = bookRepository.findById(id).get();
	    bookResponseDTO = BookResponseDTO.builder()
					.id(book.getId()).author(book.getAuthor()).country(book.getCountry())
					.gender(book.getGender()).isbn(book.getIsbn()).publisher(book.getPublisher())
					.title(book.getTitle()).build();
		}
		catch(Exception exception) {
		logger.log(Level.SEVERE,exception.getMessage());	
		}
		return bookResponseDTO;
	}
	
	public BookResponseDTO createBook(BookRequestDTO bookRequestDTO){
		BookResponseDTO bookResponseDTO = null;
		try {
		Book book = Book.builder()
				.author(bookRequestDTO.getAuthor()).country(bookRequestDTO.getCountry()).
				gender(bookRequestDTO.getGender()).isbn(bookRequestDTO.getIsbn()).
				publisher(bookRequestDTO.getPublisher()).title(bookRequestDTO.getTitle()).build();
		bookRepository.save(book);
	    bookResponseDTO = BookResponseDTO.builder()
					.id(book.getId()).author(book.getAuthor()).country(book.getCountry())
					.gender(book.getGender()).isbn(book.getIsbn()).publisher(book.getPublisher())
					.title(book.getTitle()).build();
		}
		catch(Exception exception) {
		logger.log(Level.SEVERE,exception.getMessage());	
		}
		return bookResponseDTO;
	}
	
	public BookResponseDTO updateBook(UpdateBookDTO updateBookDTO){
		BookResponseDTO bookResponseDTO = null;
		try {
		
		bookRepository.updateBook(updateBookDTO.getAuthor(),updateBookDTO.getTitle(),updateBookDTO.getId());
		Book book = bookRepository.findById(updateBookDTO.getId()).get();
	    bookResponseDTO = BookResponseDTO.builder()
					.id(book.getId()).author(book.getAuthor())
					.title(book.getTitle()).country(book.getCountry()).gender(book.getGender())
					.publisher(book.getPublisher()).isbn(book.getIsbn()).build();
		}
		catch(Exception exception) {
		logger.log(Level.SEVERE,exception.getMessage());	
		}
		return bookResponseDTO;
	}
	
	public void deleteBook(Long id){
		try {
		Book book = bookRepository.findById(id).get();
		if(null != book)
			bookRepository.delete(book);
		}
		catch(Exception exception) {
		logger.log(Level.SEVERE,exception.getMessage());	
		}
	}

}
