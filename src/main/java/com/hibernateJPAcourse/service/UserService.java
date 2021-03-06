package com.hibernateJPAcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernateJPAcourse.model.User;
import com.hibernateJPAcourse.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser() {
	
		return  (List<User>) userRepository.findAll();
	}

	public Optional<User> getUserById(Integer id) {
		return	userRepository.findById(id);
		
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
		
	}



	public void DeleteUser(Integer id) {
	    userRepository.deleteById(id);
	}


}
