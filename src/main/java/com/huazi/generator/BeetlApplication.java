package com.huazi.generator;

import org.beetl.core.GroupTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.huazi.generator.common.util.SpringUtil;

@SpringBootApplication
@ComponentScan("com.huazi.generator")
public class BeetlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeetlApplication.class, args);
		GroupTemplate groupTemplate= (GroupTemplate) SpringUtil.getBean("groupTemplate");
		System.out.println("args = [" + groupTemplate + "]");
	}
}
