package com.kosta.service;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;


public interface CriminalService {

	/**
	 * ��ü���ڵ� �˻�
	 * list�� ����
	 */
	List<CrimeInfoDTO> SelectAll() throws SQLException;
	
	List<ArrestDayDTO> SelectAll2() throws SQLException;
	
	/**
	 * �ߺз� �������� �˻� 
	 */
	List<String> CallMidCrime(String name) throws SQLException;
	
	
	/**
	 * ���˺� �߻�Ƚ�� �˻�
	 */
	CrimeInfoDTO SearchOccur(String supercime) throws SQLException;
	/**
	 * ���˺� �˰űⰣ �˻� 
	 */
	ArrestDayDTO SearchArrest(String midcrime) throws SQLException;
	
	/**
	 * �����ϱ� 
	 * �����ڵ忡 �ش��ϴ� �ڸ�Ʈ ����
	 */
	int managerUpdate(String name,String comments) throws SQLException;
	int managerUpdate2(String name,String comments) throws SQLException;
	
	/** ��й�ȣ ����
	 * ��й�ȣ�� property���ϰ� ���ϰ� 3ȸ�̻� Ʋ���� ���α׷��� ����
	 */
	boolean PWCheck (String password) throws Exception;
}
