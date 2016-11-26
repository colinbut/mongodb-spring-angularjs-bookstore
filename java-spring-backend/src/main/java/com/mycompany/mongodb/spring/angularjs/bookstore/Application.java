package com.mycompany.mongodb.spring.angularjs.bookstore;

import com.mycompany.mongodb.spring.angularjs.bookstore.model.Book;
import com.mycompany.mongodb.spring.angularjs.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Application
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        bookRepository.deleteAll();

        bookRepository.save(new Book("A Tale of Two Cities", "Charles Dickens", 10, "Novel"));
        bookRepository.save(new Book("The Da Vinci Code", "Dan Brown", 12, "Thriller"));
        bookRepository.save(new Book("Think and Grow Rich", "Napoleon Hill", 10, "Motivation"));
        bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", 8, "Fantasy"));
        bookRepository.save(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 8, "Novel"));

        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }

        Book bookToUpdate = bookRepository.findByTitle("The Da Vinci Code");
        bookToUpdate.setPrice(5);
        bookRepository.save(bookToUpdate);

        Book bookToDelete = bookRepository.findByTitle("The Hobbit");
        bookRepository.delete(bookToDelete);
    }
}
