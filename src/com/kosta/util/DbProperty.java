package com.kosta.util;


/** 
 * DB���� ������ ����ʵ�� ����
 * ��������� ����� �� ���ϸ� �����ϸ� �ȴ�.
 */

public interface DbProperty {
	public static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	//������ �ʾƵ� �ڵ��̴�
	//���� �ָ� �ȵȴ�..
	public static final String URL="jdbc:oracle:thin:@192.168.0.103:1521:xe";
	//��ҹ��� �Ȱ���, xe�� SID�̸�
	public static final String USER="crime";
	public static final String PASSWORDNAME="1234";
}
 