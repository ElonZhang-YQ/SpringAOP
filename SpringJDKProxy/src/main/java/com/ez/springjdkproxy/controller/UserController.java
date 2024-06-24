package com.ez.springjdkproxy.controller;

import com.ez.springjdkproxy.bean.User;
import com.ez.springjdkproxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserController
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/10
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/signIn")
	public User signIn(String username, String password) {

		return userService.signIn(username, password);
	}
}