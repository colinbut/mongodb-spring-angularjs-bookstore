/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.mongodb.spring.angularjs.bookstore.repository;

import com.mycompany.mongodb.spring.angularjs.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends MongoRepository<Book, String> {


    Book findByTitle(@Param("title") String title);

    @Query("{ 'type' : ?0 }")
    List<Book> findByType(@Param("type") String type);

    @Query("{ 'type' : {$ne : ?0} }")
    List<Book> findByTypeNot(@Param("type") String type);

    List<Book> findByAuthor(@Param("author") String author);

}
