package fi.haaga.helia.Bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;

@Column(name = "title")
private String title;
@Column(name = "author")
private String author;
@Column(name = "isbn")
private String isbn;
@Column(name = "year")
private int year;
@Column(name = "price")
private double price;


public Book() {
	super();
}


public Book(String title, String author, String isbn, int year, double price) {
	super();
	this.title = title;
	this.author = author;
	this.isbn = isbn;
	this.year = year;
	this.price = price;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getAuthor() {
	return author;
}


public void setAuthor(String author) {
	this.author = author;
}


public String getIsbn() {
	return isbn;
}


public void setIsbn(String isbn) {
	this.isbn = isbn;
}


public int getYear() {
	return year;
}


public void setYear(int year) {
	this.year = year;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public long getId() {
	return id;
}


@Override
public String toString() {
	return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
			+ ", price=" + price + "]";
}


}
