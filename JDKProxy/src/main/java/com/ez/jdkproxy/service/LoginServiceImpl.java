package com.ez.jdkproxy.service;

/**
 * 被代理类
 *
 * @Classname LoginServiceImpl
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/1
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String username, String password) {

        return username + ":" + password;
    }
}
