package com.ez.springproxy.service;

import com.ez.springproxy.bean.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/2
 */
public interface UserService {

	User signIn(String username, String password);
}
