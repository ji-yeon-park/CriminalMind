package com.kosta.util;



import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB������ ���� �ε�, ����, ����
 * */


// �������̽� implements ���� ��밡��? ���Ŭ������ �ص������� public static final�������� ���� interface�� ������
// static{} �����Ѱ�? ���κ��� ��������Ǵ� �޼ҵ� ������ ���(ȣ��ȵ�), �� ���Ͽ� �ѹ� �ü� ����
// execute pk�ΰ�� �����ε�?? - �߸�������, pk�ΰ�� while���� list�� �ʿ���°�

public class DbUtil {

	
	
	/*
	 * �ε�
	 * ������Ʈ ���۽� �����
	 */
	
//	static {
//		try {
//		Class.forName(DbProperty.DRIVER_NAME);
//		System.out.println("ȣ��");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public DbUtil() {
		try {
		Class.forName(DbProperty.DRIVER_NAME);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 * Ŀ�ؼ��� �����ϸ� �ȵȴ�, �ʿ��Ҷ����� Ŀ�ؼ��� �����ؼ� �����ͼ� ����Ѵ�.
	 * �ȱ׷��� �ϳ��� ������ �Ǿ����
	 * ���� ����Ÿ�� Connection 
	 * ���ٿ��Ǹ� ���ؼ� static�� ������, �����������
	 */
	public static Connection getConnection() throws SQLException {
	
			return DriverManager.getConnection(DbProperty.URL, DbProperty.USER, DbProperty.PASSWORDNAME);
	}
	
	//�����ϴ� �ʿ����� ���ܰ� �߻��� ���̴�.
	//�ߺ��ڵ带 ���̱� ���ؼ� ȣ���ϴ� ������ throw���
	
	/**
	 * �ݱ�(DB���� ���� ��ü�� close()�Ѵ�)
	 * 
	 * ���� ��ü : Connection ,Statement, PreparedStatement, ResultSet)
	 * 
	 * Statement�� ������ PreparedStatement�� ������ �𸥴�?
	 *  - Statement�� �θ��̹Ƿ� ������ ����
	 *  
	 *  ResultSet�� select�������� ���ȴ�.
	 *  
	 * 	insert, update, delete -> Connection, Statement
	 *  select -> Connection, Statement, ResultSet
	 */
	
	/**
	 * �ݱ� (INSERT, UPDATE, DELETE)
	 */
	public static void dbClose(Connection con, Statement stmt){
		try {
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
		//nullpoint ������ ���ϱ� ����
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}	
	
	/**
	 * �ݱ� (SELECT)
	 */
	
	public static void dbClose(Connection con, Statement stmt, ResultSet rs){
		try {
			if(rs !=null) rs.close();	
			dbClose(con,stmt);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}

// sql���� ��Ʈ�����̿��� ������ üũ���� �ʰ� �����, (����ܰ迡�� ���� �߻�)
// �ڹٿ��� �����ϴ� �÷������� ���� �׽�Ʈ �� �� �ִ�.
