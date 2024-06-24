package com.ez.springjdkproxy.service;

import com.ez.springjdkproxy.bean.User;
import com.ez.springjdkproxy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/10
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User signIn(String username, String password) {

		return userMapper.selectUserByUsernamePassword(username, password);
	}
}
