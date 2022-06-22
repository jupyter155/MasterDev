package com.example.Task6_mongoDB.service;

import com.example.Task6_mongoDB.entity.Book;
import com.example.Task6_mongoDB.reponsitory.BooksReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService{
    @Autowired
    private BooksReponsitory repo;

    @Override
    public List<Book> getAll(){
        return this.repo.findAll();
    }

    @Override
    public String addBook(Book book){
        repo.save(book);
        return "Added Successfully";
    }

    @Override
    public void deleteBook(String id){
        repo.deleteById(id);
    }

    @Override
    public String updateBook(String id , Book BookDetails){
        Optional<Book> updateBook = repo.findById(id);
        Book update  = updateBook.get();
        update.setBookName(BookDetails.getBookName());
        update.setAuthor(BookDetails.getAuthor());
        update.setDate(BookDetails.getDate());
        update.setDescribe(BookDetails.getDescribe());
        repo.save(update);
        return "update successfully";
    }

}
