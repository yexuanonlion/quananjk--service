package com.zxf.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//远程用
			
			//本地测试用
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quananjk?" +
					"useUnicode=true&characterEncoding=utf8",
					"root","*************");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	public static void close(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(getConnection());
	}
}
