package com.kosta.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CriminalDbUtil {
	private static Properties proFile = new Properties();
	
	public static Properties getProFile() {
		return proFile;
	}
	/**
	   * 로드   getProperty 여기는 나중에 다시 만져야 겠다 
	   * */
		static {
			
			try {
				proFile.load(
				new FileInputStream("properties/Dbproperty.properties"));
				
			  Class.forName(proFile.getProperty("driverName"));
			  
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	  /**
	   * 연결  getProperty 여기도 나중에 다시 만지겠다 
	   * */
		public static Connection getConnection()throws SQLException{
			return DriverManager.getConnection(
					proFile.getProperty("url"),
					proFile.getProperty("userName"), 
					proFile.getProperty("userPass"));
		}
		
		
		
	  /**
	   * 닫기(insert, update, delete - DML전용)
	   * */
		public static void dbClose(Connection con , Statement stmt){
			try {
			 if(stmt!=null) stmt.close();
			 if(con!=null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 닫기(SELECT 전용)
		 * */
		public static void dbClose(Connection con, Statement stmt, ResultSet rs){
			try {
			  if(rs !=null) rs.close();
			  dbClose(con, stmt);
			  
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
}
