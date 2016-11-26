/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.mongodb.spring.angularjs.bookstore.repository;

import com.mycompany.mongodb.spring.angularjs.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {


    Book findByTitle(String title);

    @Query("{ 'type' : ?0 }")
    List<Book> findByType(String type);

    @Query("{ 'type' : {$ne : ?0} }")
    List<Book> findByTypeNot(String type);

    List<Book> findByAuthor(String author);

}
