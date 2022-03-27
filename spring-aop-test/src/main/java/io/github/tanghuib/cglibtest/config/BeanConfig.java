package io.github.tanghuib.cglibtest.config;

import io.github.tanghuib.cglibtest.bean.InnerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanghuibo
 * @date 2022/3/24上午2:24
 */
@Configuration
public class BeanConfig {

    Logger log = LoggerFactory.getLogger(BeanConfig.class);

    @Bean
    InnerBean innerBean() {
        log.info("innerBean Class name: {}" + BeanConfig.class.getName());
        return new InnerBean();
    }
}
