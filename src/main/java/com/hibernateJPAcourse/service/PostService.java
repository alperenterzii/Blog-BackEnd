package com.hibernateJPAcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernateJPAcourse.model.Post;
import com.hibernateJPAcourse.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		return (List<Post>) postRepository.findAll();
	}

	public Optional<Post> findById(Integer id) {
		return postRepository.findById(id);
	}

	public void addPost(Post post) {
	
		postRepository.save(post);
		
	}

	public void updatePost(Post post) {
		postRepository.save(post);
		
	}

	public void deletePost(Integer id) {
		postRepository.deleteById(id);
		
	}

	

}
