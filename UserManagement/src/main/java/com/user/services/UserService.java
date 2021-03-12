package com.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public interface UserService {

	public User save(User user);

	public List<User> findByFirstNameOrSurNameAndPinCode(String firstName, String surName, Integer pinCode);

	public List<User> findByJoinDate();

	public Optional<User> findById(Integer userId);

	public void deleteByUserId(Integer userId);

}
