package com.example.Task6_mongoDB.service;

import com.example.Task6_mongoDB.entity.Book;

import java.util.List;

public interface BooksService
{
    List<Book> getAll();
    String addBook(Book book);
    void deleteBook(String id);
    String updateBook(String id, Book book);

}
