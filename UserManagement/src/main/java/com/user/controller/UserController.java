package com.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User theUser) {
		return userService.save(theUser);
	}

	@GetMapping("/user")
	public List<User> getUserByFirstNameOrSurnameAndPincode(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String surName, @RequestParam(required = false) Integer pinCode) {
		return userService.findByFirstNameOrSurNameAndPinCode(firstName, surName, pinCode);
	}

	@GetMapping("/userjoindate")
	public List<User> getUserByJoinDate() {
		return userService.findByJoinDate();
	}

	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User theUser, @PathVariable Integer userId) {
		Optional<User> result = userService.findById(userId);
		if (!result.isPresent())
			return ResponseEntity.notFound().build();
		theUser.setUserId(userId);
		userService.save(theUser);
		return new ResponseEntity<>(userService.save(theUser), HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer userId) {
		Optional<User> result = userService.findById(userId);
		if (!result.isPresent())
			return ResponseEntity.notFound().build();
		userService.deleteByUserId(userId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
