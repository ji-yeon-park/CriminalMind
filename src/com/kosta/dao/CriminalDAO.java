package com.kosta.dao;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.CriminalDTO;

public interface CriminalDAO {

	/**
	 * ��ü���ڵ� �˻�
	 * list�� ����
	 */
	List<CriminalDTO> getSelectAll() throws SQLException;
	
	/**
	 * �ߺз����˸� �˻�
	 */
	List<CriminalDTO> CallMidCrime(String str) throws SQLException;
	
	/**
	 * ���˺� �߻�Ƚ�� �˻�
	 */
	int SearchOccur(int number) throws SQLException;
	
	
	/**
	 * ���˺� �˰űⰣ �˻� 
	 */
	int SearchArrest(String midcrime) throws SQLException;
	
	/**
	 * �����ϱ� 
	 * �����ڵ忡 �ش��ϴ� �ڸ�Ʈ ����
	 */
	int managerUpdate(CriminalDTO criminalDTO) throws SQLException;
	
	
	/**
	 * �����ϱ� 
	 * �����ڵ忡 �ش��ϴ� �ڸ�Ʈ ���� 
	 */
	int managerDelete(String id) throws SQLException;
	
	
}
