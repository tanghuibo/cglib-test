package io.github.tanghuib.cglibtest;

import io.github.tanghuib.cglibtest.aop.BeanMethodInterceptor;
import io.github.tanghuib.cglibtest.bean.InnerBean;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * @author tanghuibo
 * @date 2022/3/26上午4:20
 */
public class CglibDispTest {

    private static String getTexName() {
        return "win32-x86";
    }

    @Test
    public void test() {
        Enhancer e = new Enhancer();
        e.setSuperclass(InnerBean.class);
        CallbackFilter xx = new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if(method.getName().equals("getTexName")) {
                    return 1;
                }
                return 0;
            }
        };
        e.setCallbackFilter(xx);
        e.setInterfaces(new Class[] {Tex.class} );
        e.setCallbacks(new Callback[] {
                new BeanMethodInterceptor(),
                (Dispatcher) () -> (Tex) CglibDispTest::getTexName
        });
        InnerBean proxyBean = (InnerBean)e.create();
        System.out.println(((Tex) proxyBean).getTexName());
        proxyBean.sayHello("ssxx");
    }

    public static interface Tex {
        String getTexName();
    }
}
