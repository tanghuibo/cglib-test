package io.github.tanghuib.cglibtest;

import io.github.tanghuib.cglibtest.bean.InnerBean;
import org.junit.jupiter.api.Test;
import org.springframework.objenesis.SpringObjenesis;

/**
 * @author tanghuibo
 * @date 2022/3/24上午4:03
 */
public class SpringObjenesisTest {

    @Test
    public void test() {
        SpringObjenesis springObjenesis = new SpringObjenesis();
        InnerBean innerBean1 = springObjenesis.newInstance(InnerBean.class, false);
        InnerBean innerBean2 = springObjenesis.newInstance(InnerBean.class, false);
        InnerBean innerBean3 = springObjenesis.newInstance(InnerBean.class, false);
        InnerBean innerBean4 = springObjenesis.newInstance(InnerBean.class, false);
        InnerBean innerBean5 = springObjenesis.newInstance(InnerBean.class, false);
        System.out.println(innerBean1.sayHello("gga"));
        InnerBean innerBean6 = new InnerBean();
        new InnerBean();
        new InnerBean();
        new InnerBean();
        new InnerBean();
        new InnerBean();
        System.out.println(innerBean6.sayHello("zz"));
        System.out.println(innerBean2.sayHello("zz"));
    }
}
