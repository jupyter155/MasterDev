package com.example.task2_api_user.repository;

import com.example.task2_api_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

