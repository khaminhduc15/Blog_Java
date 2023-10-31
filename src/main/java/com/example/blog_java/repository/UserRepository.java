package com.example.blog_java.repository;

import com.example.blog_java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsernameAndPassword (String username, String password);
    User findAllById(Long id);
}
