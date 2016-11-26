/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.mongodb.spring.angularjs.bookstore.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class BookStoreConfiguration extends AbstractMongoConfiguration {

    private static final String MONGODB_CONNECTION_URL = "127.0.0.1"; // localhost
    private static final int MONGODB_DEFAULT_CONNECTION_PORT = 27017;

    @Override
    protected String getDatabaseName() {
        return "bookstore-db";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(MONGODB_CONNECTION_URL, MONGODB_DEFAULT_CONNECTION_PORT);
    }

}
