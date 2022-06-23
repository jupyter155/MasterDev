package com.example.Task6_mongoDB.entity;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity

@Document(collection = "minhnx12")
public class Book {
    @Id
    private String id;
    private @TextIndexed String bookName;
    private @TextIndexed String author;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String describe;

}
