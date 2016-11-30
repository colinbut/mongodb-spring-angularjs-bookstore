package com.mycompany.mongodb.spring.angularjs.bookstore;

import com.mycompany.mongodb.spring.angularjs.bookstore.dao.BookDao;
import com.mycompany.mongodb.spring.angularjs.bookstore.model.Book;
import com.mycompany.mongodb.spring.angularjs.bookstore.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * BookStore application
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDao bookDao;

    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("Deleting books from Collection");
        bookRepository.deleteAll();

        LOGGER.info("Adding books to Collection");
        for (Book book : getBooksToAdd()) {
            LOGGER.debug("Adding new book: {} to to be Collection", book);
            bookRepository.save(book);
        }

        for (Book book : bookRepository.findAll()) {
            LOGGER.debug("{}", book);
        }


        Book bookToUpdate = bookRepository.findByTitle("The Da Vinci Code");
        bookToUpdate.setPrice(5);
        LOGGER.info("Updating book: {}", bookToUpdate);
        bookRepository.save(bookToUpdate);

        Book bookToDelete = bookRepository.findByTitle("The Hobbit");
        LOGGER.info("Deleting book: {}", bookToDelete);
        bookRepository.delete(bookToDelete);
    }

    private static List<Book> getBooksToAdd() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("A Tale of Two Cities", "Charles Dickens", 10, "Novel"));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 12, "Thriller"));
        books.add(new Book("Think and Grow Rich", "Napoleon Hill", 10, "Motivation"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 8, "Fantasy"));
        books.add(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 8, "Novel"));
        return books;
    }

}
