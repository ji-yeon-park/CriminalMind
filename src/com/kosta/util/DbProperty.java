package com.kosta.util;


/** 
 * DB설정 정보를 상수필드로 관리
 * 변경사항이 생길시 이 파일만 변경하면 된다.
 */

public interface DbProperty {
	public static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	//붙히지 않아도 자동이다
	//공백 주면 안된다..
	public static final String URL="jdbc:oracle:thin:@192.168.0.103:1521:xe";
	//대소문자 안가림, xe는 SID이름
	public static final String USER="crime";
	public static final String PASSWORDNAME="1234";
}
 