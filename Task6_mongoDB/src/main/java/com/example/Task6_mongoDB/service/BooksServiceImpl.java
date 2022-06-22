package com.example.Task6_mongoDB.service;

import com.example.Task6_mongoDB.entity.Book;
import com.example.Task6_mongoDB.reponsitory.BooksReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService{
    @Autowired
    private BooksReponsitory repo;

    @Autowired
    private MongoTemplate mongoTemplate;

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
    @Override
    public List<Book> findBooksByDateBetween2(Date startDate, Date endDate){
        Query query = new Query();
        query.addCriteria(Criteria.where("date").lt(startDate).gt(endDate));
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }

}
