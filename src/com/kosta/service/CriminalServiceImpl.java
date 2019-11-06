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
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return list;
	}
	
	@Override
	public List<CriminalDTO> CallMidCrime(String name) throws SQLException {
		List<CriminalDTO> list = dao.CallMidCrime(name);
		if(list == null || list.isEmpty()) {
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return list;
	}
	 
	
	@Override
	public int SearchOccur(int number) throws SQLException {
		int occur = dao.SearchOccur(number);
		if(occur ==0)
			throw new SQLException(number+"에 대한 정보가 없습니다.");
		
		return occur;
	}
	@Override
	public int SearchArrest(String midcrime) throws SQLException {
		int arrest = dao.SearchArrest(midcrime);
		if(arrest ==0)
			throw new SQLException(midcrime+"에 대한 정보가 없습니다.");
		
		return arrest;
	}
	@Override
	public int managerUpdate(CriminalDTO criminalDTO) throws SQLException {
		 int result = dao.managerUpdate(criminalDTO);
		 if(result==0)throw new SQLException("수정되지 않았습니다.");
		 return result;
	}


	@Override
	public int managerDelete(String id) throws SQLException {
		int result = dao.managerDelete(id);
		if(result == 0) throw new SQLException("삭제되지 않았습니다");
		return result;
	}


	@Override
	public int SearchOccur(String supercime) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
