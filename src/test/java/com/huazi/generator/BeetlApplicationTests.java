package com.huazi.generator;

import com.huazi.generator.generator.*;
import com.huazi.generator.generator.database.dbDataType.DbDataType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeetlApplicationTests {

	@Test
	public void contextLoads() throws SQLException, ClassNotFoundException {
		new EntityGenerator("sys_log");
		new MapperGenerator("sys_log");
		new MapperXmlGenerator("sys_log");
		new ServiceGenerator("sys_log");
		new ServiceImplGenerator("sys_log");
	}

}
