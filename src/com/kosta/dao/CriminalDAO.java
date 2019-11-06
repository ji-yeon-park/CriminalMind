package com.kosta.dao;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;


public interface CriminalDAO {

	/**
	 * ��ü���ڵ� �˻�
	 * list�� ����
	 */
	List<CrimeInfoDTO> getSelectAll() throws SQLException;
	
	List<ArrestDayDTO> getSelectAll2() throws SQLException;
	
	/**
	 * �ߺз����˸� �˻�
	 */
	List<String> CallMidCrime(String str) throws SQLException;
	
	/**
	 * ���˺� �߻�Ƚ�� �˻�
	 */
	CrimeInfoDTO SearchOccur(String str) throws SQLException;
	
	
	/**
	 * ���˺� �˰űⰣ �˻� 
	 */
	ArrestDayDTO SearchArrest(String str) throws SQLException;
	
	/**
	 * �����ϱ� 
	 * �����ڵ忡 �ش��ϴ� �ڸ�Ʈ ����
	 */
	int managerUpdate(String name, String comments) throws SQLException;
	int managerUpdate2(String name, String comments) throws SQLException;
	

}
