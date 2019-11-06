package com.kosta.service;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dao.CriminalDAO;
import com.kosta.dao.CriminalDAOImpl;
import com.kosta.dto.CriminalDTO;

public class CriminalServiceImpl implements CriminalService {
	CriminalDAO dao = new CriminalDAOImpl();
	
	@Override
	public List<CriminalDTO> SelectAll() throws SQLException {
		List<CriminalDTO> list = dao.getSelectAll();
		if(list == null || list.isEmpty()) {
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return list;
	}
	
	
	@Override
	public int SearchOccur(String supercrime) throws SQLException {
		int occur = dao.SearchOccur(supercrime);
		if(occur ==0)
			throw new SQLException(supercrime+"�� ���� ������ �����ϴ�.");
		
		return occur;
	}
	@Override
	public int SearchArrest(String midcrime) throws SQLException {
		int arrest = dao.SearchArrest(midcrime);
		if(arrest ==0)
			throw new SQLException(midcrime+"�� ���� ������ �����ϴ�.");
		
		return arrest;
	}
	@Override
	public int managerUpdate(CriminalDTO criminalDTO) throws SQLException {
		 int result = dao.managerUpdate(criminalDTO);
		 if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		 return result;
	}


	@Override
	public int managerDelete(int code) throws SQLException {
		int result = dao.managerDelete(code);
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�");
		return result;
	}

	
	
}
