package io.github.tanghuib.cglibtest.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author tanghuibo
 * @date 2022/4/7下午8:26
 */
@Component
public class ABean {

    static Logger log = LoggerFactory.getLogger(ABean.class);
    private final BBean bBean;

    public ABean(@Lazy BBean bBean) {
        log.info("ABean init");
        this.bBean = bBean;
    }

    public void test() {
        log.info("b bean name is {}", bBean.getName());
    }

    public String getName() {
        return "aBean02";
    }
}
