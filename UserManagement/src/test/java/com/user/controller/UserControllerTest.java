package com.user.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.user.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
//@WithMockUser
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserService userService;

	// getUserByJoinDate(){

}
