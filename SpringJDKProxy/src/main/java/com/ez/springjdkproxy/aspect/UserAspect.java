package com.ez.springjdkproxy.aspect;

import com.esotericsoftware.minlog.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Classname UserAspect
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/10
 */
@EnableAspectJAutoProxy
@Component
@Aspect
public class UserAspect {

	@Pointcut("execution(* com.ez.springjdkproxy.service.*.*(..))")
	private void userPointCutMethod() {

	}

	@Before("userPointCutMethod()")
	public void beforeMethod() {

		Log.info("beforeMethod");
	}

	@Around("userPointCutMethod()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {

		Log.info("Before Around Method");
		Object proceed = pjp.proceed();
		Log.info("aroundMethod: " + proceed);
		String name = pjp.getSignature().getName();
		Log.info("Around Method: " + name);
		Log.info("After Around Method");
		return proceed;
	}

	@AfterReturning(pointcut = "userPointCutMethod()", returning = "result")
	public void afterMethodReturn(Object result) {

		Log.info("afterMethodReturn: " + result);
	}

	@After("userPointCutMethod()")
	public void afterMethod() {

		Log.info("AfterMethod Finished");
	}
}
