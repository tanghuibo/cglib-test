package io.github.tanghuib.cglibtest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author tanghuibo
 * @date 2022/3/24上午2:24
 */
@Component
@Aspect
public class BeanAspect {

    @Around("execution(String io.github.tanghuib.cglibtest.bean.InnerBean.sayHello(String))")
    public Object sayHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("say hello init");
        return joinPoint.proceed(joinPoint.getArgs());
    }
}
