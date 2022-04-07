# spring aop

## cglib

核心流程

=============== callBack ===============

org.springframework.aop.framework.CglibAopProxy.DynamicAdvisedInterceptor

org.springframework.aop.framework.CglibAopProxy.CglibMethodInvocation.proceed

org.springframework.aop.framework.ReflectiveMethodInvocation.proceed

org.springframework.aop.aspectj.AspectJAroundAdvice.invoke

org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(org.aspectj.lang.JoinPoint, org.aspectj.weaver.tools.JoinPointMatch, java.lang.Object, java.lang.Throwable)

=============== aop 代码 ===============

org.springframework.aop.framework.CglibAopProxy.CglibMethodInvocation.proceed

org.springframework.aop.framework.ReflectiveMethodInvocation.proceed

org.springframework.aop.framework.CglibAopProxy.CglibMethodInvocation.invokeJoinpoint

=============== 业务代码 ===============

## 构造器循环依赖

可以通过 @Lazy 生成代理对象实现依赖注入，但要求在构造器内不调用被依赖类的方法 (因为实际在构造期间传入的可能是空的代理对象)