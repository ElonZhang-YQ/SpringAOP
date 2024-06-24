package com.ez.springjdkproxy.service;

import com.ez.springjdkproxy.bean.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/10
 */
public interface UserService {

	User signIn(String username, String password);
}
