package com.example.springmvc.controller;

import com.example.springmvc.model.Post;
import com.example.springmvc.repository.PostRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

  @Autowired
  private PostRepository repository;

  @GetMapping
  public ResponseEntity<List<Post>> getAllPosts() {
    return ResponseEntity.ok(repository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(repository.findById(id).orElseThrow());
  }

  @PostMapping
  public ResponseEntity<Map<String, Long>> createPost(
      @RequestBody Post payload
  ) {
    var createdPost = repository.save(payload);
    var response = Map.of("id", createdPost.getId());

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String,String>> deletePost(@PathVariable("id") Long id) {
    try {
      repository.deleteById(id);
      return ResponseEntity.ok(Map.of("message","Success delete data"));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(Map.of("message", "Fail delete data"));
    }
  }

}
