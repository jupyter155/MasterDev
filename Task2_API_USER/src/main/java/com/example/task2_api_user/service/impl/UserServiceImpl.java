package com.example.task2_api_user.service.impl;

import com.example.task2_api_user.entity.User;
import com.example.task2_api_user.exception.DuplicateRecordException;
import com.example.task2_api_user.exception.NotFoundException;
import com.example.task2_api_user.exception.ResourceNotFoundException;
import com.example.task2_api_user.repository.UserRepository;
import com.example.task2_api_user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    @Override
    public User getUserId(@PathVariable long id) throws NotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(" User not exits with id " + id));
    }

    public boolean checkEmail(String email) {
        List<User> listUser = this.userRepository.findAll();
        if (listUser.isEmpty()) {
            return false;
        }
        for (User user : listUser) {
            if (Objects.equals(user.getEmail(), email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String createUser(User user) throws DuplicateRecordException {
        if (this.checkEmail(user.getEmail())){
            return "Email already exist";
        }
        else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepository.save(user);
            return "Done !";
        }
    }

    @Override
    public String updateUser(@PathVariable long id , User UserDetails){
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException( " User not exists with id " +id));
        updateUser.setEmail(UserDetails.getEmail());
        updateUser.setPassword(UserDetails.getPassword());
        updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        userRepository.save(updateUser);
        return "update successfully";
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException ( " User not exits with id " + id));
        userRepository.delete(user);
    }
}
