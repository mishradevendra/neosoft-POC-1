package com.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;

	}

	@Override
	public User save(User theUser) {
		return userRepository.save(theUser);
	}

	public List<User> findByFirstNameOrSurNameAndPinCode(String firstName, String surName, Integer pinCode) {
		return userRepository.findByFirstNameOrSurNameOrPinCode(firstName, surName, pinCode);

	}

	public List<User> findByJoinDate() {
		return userRepository.findByOrderByJoinDateAsc();
	}

	@Override
	public Optional<User> findById(Integer userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public void deleteByUserId(Integer userId) {
		userRepository.deleteById(userId);

	}

}
