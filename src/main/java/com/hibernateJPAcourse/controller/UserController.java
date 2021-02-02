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
import com.hibernateJPAcourse.model.User;
import com.hibernateJPAcourse.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		
		return userService.getAllUser();
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/user/{id}/posts")
	public List<Post>  getPostByUser(@PathVariable Integer id){
		Optional<User> user = userService.getUserById(id);
		 if(user.isPresent()) {
				return user.get().getPosts();
			    }
			    return null;
	}
	
	@PostMapping("/user/addNew")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/user/{id}/update")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}/delete")
	public void DeleteUser(@PathVariable Integer id) {
	     userService.DeleteUser(id);
	}
}
