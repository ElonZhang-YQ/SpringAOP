package com.ez.springproxy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname UserLoginAnnotation
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/2
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginAnnotation {

}
