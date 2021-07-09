package org.camunda.hr.persistence;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory objPESqlSessionFactory;

	static {
		
		String peResource = "context/pe-mybatis-config.xml";

		InputStream objInputStream;

		try {

			objInputStream = Resources.getResourceAsStream(peResource);

			objPESqlSessionFactory = new SqlSessionFactoryBuilder().build(objInputStream);

		} catch (Exception e) {

			throw new RuntimeException("MyBatisUtil Exception:" + e.getMessage());
		}
	}

	public static SqlSessionFactory getPESqlSessionFactory() {
		return objPESqlSessionFactory;
	}
}
