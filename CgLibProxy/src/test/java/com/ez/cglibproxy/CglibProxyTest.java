package com.ez.cglibproxy;

import com.ez.cglibproxy.proxy.LoginServiceProxy;
import com.ez.cglibproxy.service.LoginService;
import org.junit.jupiter.api.Test;

/**
 * @Classname CglibProxyTest
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/2
 */
public class CglibProxyTest {

	@Test
	public void testLogServiceProxy() {
		LoginServiceProxy loginServiceProxy = new LoginServiceProxy();
		LoginService loginService = (LoginService) loginServiceProxy.getProxy(LoginService.class);
		loginService.signIn("zhangsan", "123456");
	}
}
