package com.example.blog_java.controller;

import com.example.blog_java.model.User;
import com.example.blog_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity save(@RequestBody User user){
        return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }
    @PutMapping ("/{id}")
    public ResponseEntity save(@RequestBody User user, @PathVariable Long id){
        user.setId(id);
        return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity findAllByUsernameAndPassword(@RequestBody User user){
        User users = userRepository.findAllByUsernameAndPassword(user.getUsername(), user.getPassword());
        return new ResponseEntity(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findAllById(@PathVariable Long id){
        User user = userRepository.findAllById(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
