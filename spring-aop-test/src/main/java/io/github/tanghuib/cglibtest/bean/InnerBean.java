package io.github.tanghuib.cglibtest.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author tanghuibo
 * @date 2022/3/23下午9:37
 */
public class InnerBean {

    Logger log = LoggerFactory.getLogger(InnerBean.class);

    String uuid = UUID.randomUUID().toString();

    public InnerBean() {
        log.info("className: {}, InnerBean uuid: {}", this.getClass().getName(), uuid);

    }

    public String sayHello(String name) {
        return uuid + " hello:" + name;
    }

    public void echo(Object data) {
        System.out.println("hello:" + data);
    }
}
