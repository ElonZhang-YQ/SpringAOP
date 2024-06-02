package com.ez.springproxy.aspect;

import com.esotericsoftware.minlog.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Classname UserLoginAspect
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/2
 */
@Aspect
@Component
public class UserLoginAspect {

	@Pointcut("@annotation(com.ez.springproxy.annotation.UserLoginAnnotation)")
	public void userLoginPointCut() {}

	@Before("userLoginPointCut()")
	public void before(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String methodName = methodSignature.getMethod().getName();
		Log.info("before " + methodName + "， 用户登录信息：" + joinPoint.getArgs()[0]);
	}

	@After("userLoginPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String methodName = methodSignature.getMethod().getName();
		Log.info("after " + methodName + "，用户登录成功！，登录用户：" + joinPoint.getArgs()[0]);
	}
}
