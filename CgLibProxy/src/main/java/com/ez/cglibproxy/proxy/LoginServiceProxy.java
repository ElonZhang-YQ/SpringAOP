package com.ez.cglibproxy.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname LoginServiceProxy
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/2
 */
public class LoginServiceProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		// 设置需要创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		// 通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		System.out.println("可以在调用实际方法前做的一些事");
		// 通过代理类调用父类中的方法
		Object result = method.invoke(obj, args);
		System.out.println("可以在调用实际方法后做的一些事");
		return result;
	}
}
