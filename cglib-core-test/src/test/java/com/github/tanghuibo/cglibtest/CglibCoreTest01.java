package com.github.tanghuibo.cglibtest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author tanghuibo
 * @date 2022/3/27下午3:37
 */
public class CglibCoreTest01 {

    Logger log = LoggerFactory.getLogger(CglibCoreTest01.class);
    @Test
    public void test() {
        InnerBean proxyBean = (InnerBean)Enhancer.create(InnerBean.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = methodProxy.invokeSuper(o, objects);
                log.info("init method: {}, params: {}, result: {}", method.getName(), Arrays.stream(objects).map(Object::toString).collect(Collectors.joining()), result);
                return result;
            }
        });
        String result = proxyBean.run("innerBeanParam");
        log.info("proxy result: {}", result);

    }

    private static class InnerBean {

        public InnerBean() {

        }

        public String run(String name) {
            return "run:" + name;
        }
    }
}
