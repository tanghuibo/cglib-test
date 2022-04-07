package io.github.tanghuib.cglibtest.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author tanghuibo
 * @date 2022/4/7下午8:27
 */
@Component
public class BBean {

    static Logger log = LoggerFactory.getLogger(BBean.class);

    private final ABean aBean;

    public BBean(@Lazy ABean aBean) {
        log.info("BBean init");
        this.aBean = aBean;
    }
    public String getName() {
        return "bBean01";
    }

    public void test() {
        log.info("a bean name is {}", aBean.getName());
    }
}
