package com.kosta.service;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.CriminalDTO;

public interface CriminalService {

	/**
	 * ��ü���ڵ� �˻�
	 * list�� ����
	 */
	List<CriminalDTO> SelectAll() throws SQLException;
	
	/**
	 * �ߺз� �������� �˻� 
	 */
	List<CriminalDTO> CallMidCrime(String name) throws SQLException;
	/**
	 * ���˺� �߻�Ƚ�� �˻�
	 */
	int SearchOccur(String supercime) throws SQLException;
	
	
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
	
	/**
	 * ��й�ȣ ����
	 * ��й�ȣ�� property���ϰ� ���ϰ� 3ȸ�̻� Ʋ���� ���α׷��� ����
	 */
	boolean PWCheck (String password) throws Exception;
}
