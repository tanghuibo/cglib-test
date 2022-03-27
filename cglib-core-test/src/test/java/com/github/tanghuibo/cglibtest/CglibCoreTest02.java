package com.github.tanghuibo.cglibtest;

import net.sf.cglib.proxy.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author tanghuibo
 * @date 2022/3/27下午3:37
 */
public class CglibCoreTest02 {

    Logger log = LoggerFactory.getLogger(CglibCoreTest02.class);
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InnerBean.class);

        MethodInterceptor callBack = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = methodProxy.invokeSuper(o, objects);
                log.info("init method: {}, params: {}, result: {}", method.getName(), Arrays.stream(objects).map(Object::toString).collect(Collectors.joining()), result);
                return result;
            }
        };
        enhancer.setCallbackType(MethodInterceptor.class);
        Class aClass = enhancer.createClass();
        InnerBean proxyBean = (InnerBean)aClass.getConstructor(String.class).newInstance("testInnerBean");
        ((Factory) proxyBean).setCallbacks(new Callback[] {callBack});

        String result = proxyBean.run("innerBeanParam");
        log.info("proxy result: {}", result);

    }

    private static class InnerBean {

        private final String innerBeanName;

        public InnerBean(String innerBeanName) {
            this.innerBeanName = innerBeanName;
        }

        public String run(String name) {
            return innerBeanName + " run:" + name;
        }
    }
}
