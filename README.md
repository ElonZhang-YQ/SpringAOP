## 代理模式

- 代理模式是一种常见的设计模式
- 为其他对象提供一种代理以控制对这个对象的访问。
- 在某些情况下，一个对象不适用或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用
- 分类：
  - 静态代理：在程序运行前，创建代理类，实现代理逻辑。
  - 动态代理：在程序运行过程中，使用反射机制动态创建代理类。
    - JDK动态代理
    - CGLib动态代理



## JDK动态代理的实现方式

- JDK动态代理是基于JDK自身实现的代理模式
- 主要运用了拦截器和反射机制
- 代理对象是由JDK动态生成的，而不像静态代理那种固定的代理对象和被代理类。
  - 必须实现`InvocationHandler`接口（代理类）
  - 使用`Proxy.newProxyInstance()`创建代理对象
  - **被代理对象必须要实现接口** 



## CGLib动态代理的实现方式

- CGLib（Code Generation Library）是一个开源项目，它是一个高性能，高质量的Code生成类库，可以在运行期间扩展Java类与实现Java接口。
- CGLib是个高性能代码生成包，广泛的被许多AOP框架使用。Spring AOP的拦截器。底层是通过一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。

## JDK动态代理和CGLib的区别

- JDK动态代理使用拦截器（拦截器必须实现InvocationHandler），再加上反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
  - 其核心类为 java.lang.reflect.Proxy 和 java.lang.reflect.InvocationHandler 来生成动态代理类和实例
  - 被代理的类必须要实现接口才可以，JDK动态代理只能对实现了接口的类生成代理，而不能针对类。
- CGLib利用ASM开源包，将代理对象类的class文件加载进来，修改其字节码生成子类来处理。
  - 其核心类为 net.sf.cglib.proxy.Enhancer 和 net.sf.cglib.proxy.MethodInterceptor。
  - 被代理的类不需要实现接口也可，CGLib针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法实现增强，但是因为采用的是继承，所以该类或方法最好不要声明成final，对于final类或方法是无法继承的。
  - CGLib能够动态生成被代理对象的一个子类，子类中拦截所有父类方法的调用，并且拦截器的类型为 MethodInterceptor
- JDK动态代理和CGLib动态代理速度比较：
  - 在JDK1.6之前，因为反射效率较差，所以CGLib通过ASM字节码生成代理类效率较高。
  - 在后续JDK版本中对JDK动态代理优化之后，调用次数较少的情况下，JDK代理效率高于CGLib的效率。大量调用的情况下，JDK1.6和JDK7还是会比CGLib差一些。在JDK8之后，JDK动态代理效率高于CGLib代理。

## Spring AOP的实现方式以及原理

- Spring AOP的实现方式是根据bean的不同而不同
  - 当bean实现接口时，Spring就会用JDK动态代理
  - 当bean没有实现接口时，Spring使用CGLib实现
- 也可以强制使用CGLib，在Spring配置中加入`<aop:aspectj-autoproxy proxy-target-class="true"/>`

