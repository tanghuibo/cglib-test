package com.github.tanghuibo.cglibtest;

import net.sf.cglib.proxy.*;
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
public class CglibCoreTest00 {

    Logger log = LoggerFactory.getLogger(CglibCoreTest00.class);
    @Test
    public void test() {
        InnerBean proxyBean = (InnerBean)Enhancer.create(InnerBean.class, NoOp.INSTANCE);
        String result = proxyBean.run("innerBeanParam");
        log.info("proxy result: {}", result);
    }

    private static class InnerBean {

        private String name;

        public InnerBean() {

        }

        public String run(String param) {
            return name + " run:" + param;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
