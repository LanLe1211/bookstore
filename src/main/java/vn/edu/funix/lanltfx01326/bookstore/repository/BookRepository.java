package vn.edu.funix.lanltfx01326.bookstore.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.edu.funix.lanltfx01326.bookstore.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	ArrayList<Book> findAllByOrderByIdDesc();
	

	@Query(value = "SELECT * FROM books WHERE name LIKE %:term%", nativeQuery = true)
	ArrayList<Book> findByNameContaining(@Param("term") String term);

}
