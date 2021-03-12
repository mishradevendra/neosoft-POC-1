package com.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User save(User user);

	public List<User> findByFirstNameOrSurNameOrPinCode(String firstName, String surName, Integer pinCode);

	public List<User> findByOrderByJoinDateAsc();

	public Optional<User> findByUserId(Integer userId);

	public void deleteById(Integer userId);

}
