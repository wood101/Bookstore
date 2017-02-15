package fi.haaga.helia.Bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haaga.helia.Bookstore.entities.Book;
import fi.haaga.helia.Bookstore.repository.BookRepository;

@Controller
public class BookController {
		@Autowired
		private BookRepository repository;
		
		@RequestMapping("/login")
		public String login() {
	    	return "login";
	    }	
		
	    @RequestMapping(value="/")
	    public String studentList(Model model) {	
	        model.addAttribute("books", repository.findAll());
	        return "booklist";
	    }
		
	    @RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book> BooklistRest() {	
	        return (List<Book>) repository.findAll();
	    }    
	    
	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Book findbookRest(@PathVariable("id") Long bookId) {	
	    	return repository.findOne(bookId);
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
