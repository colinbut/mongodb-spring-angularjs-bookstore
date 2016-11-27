/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.mongodb.spring.angularjs.bookstore.dao;

import com.mycompany.mongodb.spring.angularjs.bookstore.model.Book;

public interface BookDao {

    void insert(Book book);
    void insertAll(Book[] books);
    Book findByTitle(String title);

    void update(Book book);

    int deleteByTitle(String title);
    void dropCollectionIfExist();

}
