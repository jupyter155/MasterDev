package com.example.Task6_mongoDB.controller;

import com.example.Task6_mongoDB.entity.Book;
import com.example.Task6_mongoDB.reponsitory.BooksReponsitory;
import com.example.Task6_mongoDB.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RequestMapping("api/books")
@RestController
public class BookController {
    @Autowired
    private BooksService booksService;

    @Autowired
    private BooksReponsitory repo;

    @GetMapping("/findAllBooks")
    public List<Book> getAll(){
        return this.booksService.getAll();
    }

    @PostMapping("/CreateBook")
    public String addBook(@RequestBody Book book) {
        return this.booksService.addBook(book);
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable String id ,@RequestBody Book book){
        return this.booksService.updateBook(id,book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        this.booksService.deleteBook(id);
    }


    @GetMapping("/findByAuthorAndBookName")
    public List<Book> findBooksByAuthorContainsAndBookNameContains(@RequestParam(value ="author") String author,@RequestParam(value="bookName") String bookName) {
        return repo.findBooksByAuthorContainsAndBookNameContains(author,bookName);
    }

    @GetMapping("/findBooksByDate")
    public List<Book> findBooksByDateBetween(@RequestParam(value = "startDate")   @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                             @RequestParam(value = "endDate")   @DateTimeFormat(pattern = "yyy-MM-dd") Date endDate){
        return repo.findBooksByDateBetween(startDate, endDate);
    }


}
