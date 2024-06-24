package com.ez.springproxy.aspect;

import com.esotericsoftware.minlog.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

	@Around("userLoginPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String methodName = methodSignature.getMethod().getName();
		Log.info("Before Around" + methodName + "，" + joinPoint.getArgs()[0]);
		Object proceed = joinPoint.proceed();
		Log.info("do proceed: " + proceed);
		Log.info("After Around" + methodName + "，" + joinPoint.getArgs()[0]);
		return proceed;
	}
}
