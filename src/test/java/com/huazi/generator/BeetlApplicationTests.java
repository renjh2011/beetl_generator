package com.huazi.generator;

import com.huazi.generator.generator.EntityGenerator;
import com.huazi.generator.generator.Generator;
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
		Generator generator=new EntityGenerator();
	}

}
