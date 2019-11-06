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
	 * ���˺� �߻�Ƚ�� �˻�
	 */
	int SearchOccur(String supercrime) throws SQLException;
	
	
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
	int managerDelete(int code) throws SQLException;
	
	
}
