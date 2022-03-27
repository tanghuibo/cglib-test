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