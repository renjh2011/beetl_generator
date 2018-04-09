package com.huazi.generator;

import com.huazi.generator.common.util.SpringUtil;
import com.huazi.generator.generator.Generator;
import com.huazi.generator.generator.dbDataType.DbDataType;
import com.huazi.generator.generator.dbDataType.impl.mysql.MysqlDataType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeetlApplicationTests {

	@Test
	public void contextLoads() throws SQLException {
		DbDataType m=MysqlDataType.getInstance();

	}

}
