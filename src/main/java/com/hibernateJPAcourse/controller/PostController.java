package com.hibernateJPAcourse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateJPAcourse.model.Post;
import com.hibernateJPAcourse.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
	    return postService.findAll();
	}

	@GetMapping("/post/{id}")
	public Optional<Post> getPostById(@PathVariable Integer id) {
	    return postService.findById(id);
	}
	
	@PostMapping("/post/add")
	public void AddPost(@RequestBody Post post) {
		
		postService.addPost(post);
		
	}
	
	@PutMapping("/post/{id}/update")
	public void updatePost(@RequestBody Post post) {
		postService.updatePost(post);
	}
	
	@DeleteMapping("/post/{id}/delete")
	public void deletePost(@PathVariable Integer id) {
		postService.deletePost(id);
		
	}
}
