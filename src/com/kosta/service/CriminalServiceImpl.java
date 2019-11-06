package com.kosta.service;

import java.awt.color.ProfileDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.kosta.dao.CriminalDAO;
import com.kosta.dao.CriminalDAOImpl;
import com.kosta.dto.CriminalDTO;
import com.kosta.util.DbUtil;
import com.kosta.util.PwUtil;

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
	public List<CriminalDTO> CallMidCrime(String name) throws SQLException {
		
		List<CriminalDTO> list = dao.CallMidCrime(name);
		if(list == null || list.isEmpty()) {
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return list;
	}
	 
	
	@Override
	public int SearchOccur(String supercime) throws SQLException {
		int occur = dao.SearchOccur(supercime);
		if(occur ==0)
			throw new SQLException(supercime+"�� ���� ������ �����ϴ�.");
		
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
	public int managerDelete(String id) throws SQLException {
		int result = dao.managerDelete(id);
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�");
		return result;
	}


	@Override
	public int SearchOccur(String supercime) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean PWCheck(String password) throws Exception {
		return new PwUtil().PWCheck(password);
	}

	
}
