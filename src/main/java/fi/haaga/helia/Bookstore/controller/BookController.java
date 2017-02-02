package fi.haaga.helia.Bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haaga.helia.Bookstore.entities.Book;
import fi.haaga.helia.Bookstore.repository.BookRepository;

@Controller
public class BookController {
		@Autowired
		private BookRepository repository;
		
		@RequestMapping(value = "/")
		public String booklist(Model model) {
			 List<Book> books = (List<Book>) repository.findAll();
			
			model.addAttribute("books", books);
			
	    	return "booklist";
	    }

	    @RequestMapping(value = "add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	        return "addBook";
	    }	
		
	    @RequestMapping(value = "save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	    	return "redirect:/";
	    }
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	repository.delete(bookId);
	        return "redirect:/";
	    }    
	}
