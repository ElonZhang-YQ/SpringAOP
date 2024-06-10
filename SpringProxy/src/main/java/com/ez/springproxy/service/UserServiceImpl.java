package com.ez.springproxy.service;

import com.ez.springproxy.annotation.UserLoginAnnotation;
import com.ez.springproxy.annotation.UserLoginProAnnotation;
import com.ez.springproxy.bean.User;
import com.ez.springproxy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/2
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	@UserLoginAnnotation
	@UserLoginProAnnotation
	public User signIn(String username, String password) {

		return userMapper.selectUserByUsernamePassword(username, password);
	}
}
