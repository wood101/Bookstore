package fi.haaga.helia.Bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.haaga.helia.Bookstore.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByAuthor(String author);

}
