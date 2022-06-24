package com.example.task6_mongodb.reponsitory;


import com.example.Task6_mongoDB.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BooksReponsitory extends MongoRepository<Book, String> {

    List<Book> findBooksByAuthorContainsAndBookNameContains( String author, String bookName);
    List<Book> findBooksByDateBetween(Date startDate, Date endDate);
    @Query("{'$text':{$search:?0}}")
    List<Book> findByQuery(String text);

}
