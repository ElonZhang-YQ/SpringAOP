package com.ez.cglibproxy.service;

/**
 * @Classname LoginServiceImpl
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/2
 */
public class LoginServiceImpl implements LoginService{

    @Override
    public String signIn(String username, String password) {

        return username+":"+password;
    }
}
