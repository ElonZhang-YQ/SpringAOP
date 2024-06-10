package com.ez.springproxy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname UserLoginProAnnotation
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginProAnnotation {

}
