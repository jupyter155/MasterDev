package com.example.task6_mongodb.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity

@Document(collection = "book")
public class Book {
    @Id
    private String id;
    private @TextIndexed String bookName;
    private @TextIndexed String author;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String describe;

}
