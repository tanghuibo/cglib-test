package io.github.tanghuib.cglibtest;

import io.github.tanghuib.cglibtest.aop.BeanMethodInterceptor;
import io.github.tanghuib.cglibtest.bean.InnerBean;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author tanghuibo
 * @date 2022/3/24上午2:32
 */
class CglibTest {

    @Test
    void testCglib() {
        InnerBean proxyBean = (InnerBean) Enhancer.create(InnerBean.class, new BeanMethodInterceptor());
        proxyBean.sayHello("zhangSan");
    }

}