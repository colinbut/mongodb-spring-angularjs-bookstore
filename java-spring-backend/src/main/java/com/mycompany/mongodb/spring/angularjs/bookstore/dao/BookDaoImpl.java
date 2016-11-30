/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.mongodb.spring.angularjs.bookstore.dao;

import com.mongodb.WriteResult;
import com.mycompany.mongodb.spring.angularjs.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.Arrays;

@Repository
public class BookDaoImpl implements BookDao {

    private static final String BOOK_COLLECTION = "books";

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void insert(Book book) {
        mongoOperations.insert(book, BOOK_COLLECTION);
    }

    @Override
    public void insertAll(Book[] books) {
        mongoOperations.insert(Arrays.asList(books), BOOK_COLLECTION);
    }

    @Override
    public Book findByTitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        return mongoOperations.findOne(query, Book.class, BOOK_COLLECTION);
    }

    @Override
    public void update(Book book) {
        mongoOperations.save(book, BOOK_COLLECTION);
    }

    @Override
    public int deleteByTitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        WriteResult result = mongoOperations.remove(query, Book.class, BOOK_COLLECTION);
        return result.getN();
    }

    @Override
    public void dropCollectionIfExist() {
        if (mongoOperations.collectionExists(BOOK_COLLECTION)) {
            mongoOperations.dropCollection(BOOK_COLLECTION);
        }
    }

}
