package com.example.task6_mongodb.service;

import com.example.Task6_mongoDB.entity.Book;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface BooksService
{
    List<Book> getAll();
    String addBook(Book book);
    void deleteBook(String id);
    String updateBook(String id, Book book);
    List<Book> findBooksByDateBetween2(Date startDate, Date endDate);
    List<Book> findFullTextSearch(String text);
    Page<Book> readAll(int page, int size);

}
