package com.huazi.generator.test;

import com.huazi.generator.entity.Vehicle;
import org.apache.ibatis.session.SqlSession;
import org.beetl.core.GroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huazi on 2018/4/8.
 */
@Controller
public class Test {
    @Autowired
    private GroupTemplate groupTemplate;

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/test")
    @ResponseBody
    public List<Vehicle> test1() throws SQLException {
        String statement = "select * from vehicle where id <100";
        Map map=new HashMap();
        Connection connection = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(statement);
        ResultSet rs =preparedStatement.executeQuery();
        while (rs.next()){
            ResultSetMetaData rsmd=rs.getMetaData();
            int count = rsmd.getColumnCount();
            for(int i=0;i<count;i++){
                System.out.println(rsmd.getColumnName(i+1)+"----"+rsmd.getColumnTypeName(i+1)+"----"+rsmd.getColumnType(i+1));
            }
        }
        return null;
    }
}
