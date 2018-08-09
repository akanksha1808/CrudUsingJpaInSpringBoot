package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;
import com.example.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrives list of users.", response = List.class)
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@CrossOrigin
	@GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrives user for provided user id.", response = User.class)
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	@CrossOrigin
	@PostMapping(value = "/admin/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@DeleteMapping("/admin/user/{id}")
	public Boolean deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return true;
	}

	@PutMapping(value = "/admin/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

}