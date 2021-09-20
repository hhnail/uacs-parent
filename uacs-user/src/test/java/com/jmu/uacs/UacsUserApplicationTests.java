package com.jmu.uacs;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UacsUserApplicationTests {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void test01() throws SQLException {
		Connection conn = dataSource.getConnection();
		System.out.println("conn:"+conn);//代理对象
		
		conn.close();//归还连接池，并非关闭连接
	}

}
