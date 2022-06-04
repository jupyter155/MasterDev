package com.example.task2_api_user.service;

import com.example.task2_api_user.entity.User;
import org.hibernate.service.Service;

import java.util.List;

public interface UserService extends Service {
    List <User> getAllUsers();
    User getUserId(long id);
    String createUser(User u);
    void deleteUser(long id);
    String updateUser(long id, User user);
    boolean checkEmail(String email);

}
