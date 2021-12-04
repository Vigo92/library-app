package com.app.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.library.model.entity.Book;


@Repository
@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Long> {

	
	@Transactional
	@Modifying
	@Query("update Book b set b.author = ?1,b.title = ?2 where b.id = ?3")
	void updateBook(String author, String title, Long id);
}
