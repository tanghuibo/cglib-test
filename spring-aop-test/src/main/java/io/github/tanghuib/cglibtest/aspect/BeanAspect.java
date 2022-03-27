package io.github.tanghuib.cglibtest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author tanghuibo
 * @date 2022/3/24上午2:24
 */
@Component
@Aspect
public class BeanAspect {

    Logger log = LoggerFactory.getLogger(BeanAspect.class);

    @Around("execution(String io.github.tanghuib.cglibtest.bean.InnerBean.sayHello(String))")
    public Object sayHello(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("proxy before; method: {}, params: {}", "sayHello", Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(",")));
        Object result = joinPoint.proceed(joinPoint.getArgs());
        log.info("proxy over: {}", result);
        return result;

    }
}
