package com.ez.springproxy.aspect;

import com.esotericsoftware.minlog.Log;
import org.aspectj.lang.JoinPoint;
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
	public void userLoginProPointCut(){}

	@Around("userLoginProPointCut()")
	public void around(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String methodName = methodSignature.getMethod().getName();
		Log.info("Around" + methodName + "， 用户登录信息：" + joinPoint.getArgs()[0]);
	}
}
