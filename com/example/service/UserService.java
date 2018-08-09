package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entities.User;
import com.example.repository.UserRepository;
@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
	
	public User getUser(int id)	{
		
		return userRepository.findById(id).get();
	}
	
	public Boolean deleteUser(int  id)
	{
	    userRepository.deleteById(id);
		return true;
	}
	

	public User updateUser(User user)
	{
		
		return userRepository.save(user);
	}
	
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
}
