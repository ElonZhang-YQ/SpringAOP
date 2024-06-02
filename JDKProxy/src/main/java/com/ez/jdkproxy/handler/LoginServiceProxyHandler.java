package com.ez.jdkproxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 每一次动态生成代理类对象时都需要指定一个实现了InvocationHandler接口的调用处理器对象
 *
 * @Classname LoginServiceProxyHandler
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/1
 */
public class LoginServiceProxyHandler implements InvocationHandler {

    /**
     * 这个就是要代理的真实对象，也就是真正执行业务逻辑的类
     */
    private Object subject;

    /**
     * 通过构造方法传入这个被代理的对象
     * @param subject
     */
    public LoginServiceProxyHandler(Object subject) {
        this.subject = subject;
    }

    /**
     * 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
     * @param obj the proxy instance that the method was invoked on
     *
     * @param method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *
     * @param objs an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object obj, Method method, Object[] objs) throws Throwable {
        Object result = null;
        System.out.println("调用LoginService之前");
        result = method.invoke(subject, objs);
        System.out.println(method.getName() + "方法返回值是：" + result);
        System.out.println("调用LoginService之后");
        return result;
    }
}
