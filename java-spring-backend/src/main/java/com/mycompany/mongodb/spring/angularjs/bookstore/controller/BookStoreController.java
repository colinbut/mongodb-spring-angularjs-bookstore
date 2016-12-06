/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.mongodb.spring.angularjs.bookstore.controller;

import com.mycompany.mongodb.spring.angularjs.bookstore.model.Book;
import com.mycompany.mongodb.spring.angularjs.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * This REST controller handles services by providing the following services in a
 * book store:
 *
 * <ul>
 *     <li>list books
 *     <li>get a particular book
 *     <li>add a new book
 *     <li>delete existing book
 * </ul>
 *
 * @author colin
 */
@RestController("/bookstore")
public class BookStoreController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addNewBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteBook(@PathParam("bookId") Integer bookId) {
        bookRepository.delete(bookId.toString());
    }

}
