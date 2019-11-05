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
	   * �ε�   getProperty ����� ���߿� �ٽ� ������ �ڴ� 
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
	   * ����  getProperty ���⵵ ���߿� �ٽ� �����ڴ� 
	   * */
		public static Connection getConnection()throws SQLException{
			return DriverManager.getConnection(
					proFile.getProperty("url"),
					proFile.getProperty("userName"), 
					proFile.getProperty("userPass"));
		}
		
		
		
	  /**
	   * �ݱ�(insert, update, delete - DML����)
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
		 * �ݱ�(SELECT ����)
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
