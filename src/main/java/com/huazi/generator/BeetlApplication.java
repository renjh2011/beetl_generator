package com.huazi.generator;

import com.huazi.generator.test.Test;
import com.huazi.generator.util.SpringUtil;
import org.beetl.core.GroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeetlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeetlApplication.class, args);
		GroupTemplate groupTemplate= (GroupTemplate) SpringUtil.getBean("groupTemplate");
		System.out.println("args = [" + groupTemplate + "]");
//		new Test().test();
	}
}
