package io.github.tanghuib.cglibtest;

import io.github.tanghuib.cglibtest.bean.InnerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CglibTestApplication {

	static Logger log = LoggerFactory.getLogger(CglibTestApplication.class);
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(CglibTestApplication.class, args);
		InnerBean testBean = applicationContext.getBean(InnerBean.class);
		String zhangsan = testBean.sayHello("zhangsan");
		log.info("result: {}", zhangsan);
	}


}
