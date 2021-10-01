package com.cusm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cusm.common.Constant;

public class MYSQLDBmanger {

	private static final String DB_URL = "jdbc:mysql://" + Constant.MYSQL_SERVER_IP + ":"+Constant.MYSQL_SERVER_PORT+"/"+Constant.MYSQL_DATABASE_NAME+"?characterEncoding=gbk&user="+Constant.MYSQL_DATABASE_USER+"&password="+Constant.MYSQL_DATABASE_USERPWD;//"jdbc:mysql://127.0.0.1:3306/form?characterEncoding=gbk&user=dengqi&password=xiaomayi";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	
	private static Connection conn;
	
	public static Connection getConnection(){
		
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeAll(Connection conn, PreparedStatement ptst, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			if(ptst != null){
				ptst.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
