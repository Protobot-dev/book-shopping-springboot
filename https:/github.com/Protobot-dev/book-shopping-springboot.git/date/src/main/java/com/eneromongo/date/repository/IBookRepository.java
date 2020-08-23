package com.eneromongo.date.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eneromongo.date.model.Book;


public interface IBookRepository  extends MongoRepository<Book, Integer>{

}
