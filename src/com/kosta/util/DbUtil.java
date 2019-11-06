package com.kosta.util;



import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB연동을 위한 로드, 연결, 실행
 * */


// 인터페이스 implements 없이 사용가능? 사실클래스로 해도되지만 public static final성격으로 볼때 interface에 가깝다
// static{} 가능한가? 메인보다 먼저실행되는 메소드 성격의 블록(호출안됨), 한 파일에 한번 올수 있음
// execute pk인경우 오버로딩?? - 잘못이해함, pk인경우 while문과 list가 필요없는것

public class DbUtil {

	
	
	/*
	 * 로드
	 * 프로젝트 시작시 실행됨
	 */
	
//	static {
//		try {
//		Class.forName(DbProperty.DRIVER_NAME);
//		System.out.println("호엥");
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
	 * 연결
	 * 커넥션을 공유하면 안된다, 필요할때마다 커넥션을 연결해서 가져와서 사용한다.
	 * 안그러면 하나의 단위가 되어버림
	 * 따라서 리턴타입 Connection 
	 * 접근용의를 위해서 static을 붙힌다, 만들어져있음
	 */
	public static Connection getConnection() throws SQLException {
	
			return DriverManager.getConnection(DbProperty.URL, DbProperty.USER, DbProperty.PASSWORDNAME);
	}
	
	//실행하는 쪽에서도 예외가 발생할 것이다.
	//중복코드를 줄이기 위해서 호출하는 쪽으로 throw사용
	
	/**
	 * 닫기(DB관련 사용된 객체를 close()한다)
	 * 
	 * 사용된 객체 : Connection ,Statement, PreparedStatement, ResultSet)
	 * 
	 * Statement를 닫을지 PreparedStatement를 닫을지 모른다?
	 *  - Statement가 부모이므로 다형성 성립
	 *  
	 *  ResultSet은 select전용으로 사용된다.
	 *  
	 * 	insert, update, delete -> Connection, Statement
	 *  select -> Connection, Statement, ResultSet
	 */
	
	/**
	 * 닫기 (INSERT, UPDATE, DELETE)
	 */
	public static void dbClose(Connection con, Statement stmt){
		try {
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
		//nullpoint 오류를 피하기 위해
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}	
	
	/**
	 * 닫기 (SELECT)
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

// sql문은 스트링형이여서 오류가 체크되지 않고 실행됨, (실행단계에서 오류 발생)
// 자바에서 제공하는 플러그인을 통해 테스트 할 수 있다.
