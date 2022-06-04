package com.example.task2_api_user.controller;

import com.example.task2_api_user.entity.User;
import com.example.task2_api_user.exception.ResourceNotFoundException;
import com.example.task2_api_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User getUserId(@PathVariable long id){
        return this.userService.getUserId(id);
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping()
    public String createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) throws ResourceNotFoundException {
        return this.userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        this.userService.deleteUser(id);
    }
}
