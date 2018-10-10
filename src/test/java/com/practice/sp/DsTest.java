package com.practice.sp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DsTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@Autowired
	private SqlSession ss;
	
	@Test
	public void dbtest() {
		try {
			Connection con = ds.getConnection();
			System.out.println("연결성공!");
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void ssftest() {
		SqlSession ss = ssf.openSession();
		assertNotNull(ss);
	}
	
	@Test
	public void sstest() {
		assertNotNull(ss);
	}
	

}
