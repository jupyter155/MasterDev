package com.example.task11.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.task11.repo.Repo;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/completion-suggester")
public class Controller {
    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public List<String> getSuggestionSearch(@PathVariable String text) throws IOException {
        Repo repo = context.getBean(Repo.class);

        return repo.getSuggestion(text);
    }
}
