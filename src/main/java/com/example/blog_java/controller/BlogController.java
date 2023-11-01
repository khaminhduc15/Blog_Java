package com.example.blog_java.controller;

import com.example.blog_java.model.Blog;
import com.example.blog_java.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogRepository blogRepository;
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(blogRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Blog blog){
        return new ResponseEntity(blogRepository.save(blog),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@RequestBody Blog blog, @PathVariable Long id){
        blog.setId(id);
        return new ResponseEntity(blogRepository.save(blog),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        blogRepository.deleteById(id);
        return new ResponseEntity("Xóa Thành Công", HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity findAllByUserId(@PathVariable Long id){
        List<Blog> blogs = blogRepository.findAllByUserId(id);
        return new ResponseEntity(blogs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findAllById(@PathVariable Long id){
        Optional<Blog> blog = blogRepository.findById(id);
        return new ResponseEntity(blog, HttpStatus.OK);
    }
    @GetMapping("/{title}")
    public ResponseEntity findAllByTitleContain(@PathVariable String title){
        Iterable<Blog> blogs = blogRepository.findAllByTitleContaining(title);
        return new ResponseEntity(blogs, HttpStatus.OK);
    }
}
