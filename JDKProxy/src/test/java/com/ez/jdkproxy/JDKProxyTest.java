package com.ez.jdkproxy;

import com.ez.jdkproxy.handler.LoginServiceProxyHandler;
import com.ez.jdkproxy.service.LoginService;
import com.ez.jdkproxy.service.LoginServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @Classname test
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/1
 */
public class JDKProxyTest {

    @Test
    public void testLogServiceProxy() {

        /**
         * 创建被代理对象
         */
        LoginServiceImpl loginService = new LoginServiceImpl();

        /**
         * 创建handler，传入真实对象
         */
        LoginServiceProxyHandler handler = new LoginServiceProxyHandler(loginService);

        /**
         * 创建代理对象，传入类加载器、接口和Handler
         */
        LoginService loginServiceProxy = (LoginService) Proxy.newProxyInstance(LoginService.class.getClassLoader(), new Class[]{LoginService.class}, handler);

        /**
         * 调用方法
         */
        loginServiceProxy.login("zhangsan", "123456");
    }
}
