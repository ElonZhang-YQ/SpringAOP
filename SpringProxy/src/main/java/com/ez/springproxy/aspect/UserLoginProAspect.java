package com.ez.springproxy.aspect;

import com.esotericsoftware.minlog.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Classname UserLoginProAspect
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/10
 */
@Aspect
@Component
public class UserLoginProAspect {

	@Pointcut("@annotation(com.ez.springproxy.annotation.UserLoginProAnnotation)")
	public void userLoginProPointCut() {

	}

	@Around("userLoginProPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String methodName = methodSignature.getMethod().getName();
		Log.info("Before Around Pro " + methodName + "，" + joinPoint.getArgs()[0]);
		Object proceed = joinPoint.proceed();
		Log.info("do proceed Pro: " + proceed);
		Log.info("After Around Pro" + methodName + "，" + joinPoint.getArgs()[0]);
		return proceed;
	}
}
