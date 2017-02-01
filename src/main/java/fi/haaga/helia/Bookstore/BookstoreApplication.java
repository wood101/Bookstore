package fi.haaga.helia.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haaga.helia.Bookstore.entities.Book;
import fi.haaga.helia.Bookstore.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			// save Books
			repository.save(new Book("John", "Johnson", "4352623", 1999, 19.99));
			repository.save(new Book("Kate", "Keystone", "5234223", 1990, 15.20));
			repository.save(new Book("Diana", "Doll", "1231232", 2005, 20.00));
		};
	}
}

