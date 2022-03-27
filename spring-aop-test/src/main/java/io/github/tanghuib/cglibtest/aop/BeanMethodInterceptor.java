package io.github.tanghuib.cglibtest.aop;

import io.github.tanghuib.cglibtest.bean.InnerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author tanghuibo
 * @date 2022/3/23下午9:41
 */
public class BeanMethodInterceptor implements MethodInterceptor {

    Logger log = LoggerFactory.getLogger(BeanMethodInterceptor.class);
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("proxy before, method: {}, params: {}", method.getName(), Arrays.stream(objects).map(Object::toString).collect(Collectors.joining(",")));
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("proxy over:" + result);
        return result;
    }
}
