package com.kosta.service;

import java.awt.color.ProfileDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.kosta.dao.CriminalDAO;
import com.kosta.dao.CriminalDAOImpl;
import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;
import com.kosta.util.DbUtil;
import com.kosta.util.PwUtil;

public class CriminalServiceImpl implements CriminalService {
	CriminalDAO dao = new CriminalDAOImpl();
	
	@Override
	public List<CrimeInfoDTO> SelectAll() throws SQLException {
		List<CrimeInfoDTO> list = dao.getSelectAll();
		if(list == null || list.isEmpty()) {
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return list;
	}
	
	@Override
	public List<ArrestDayDTO> SelectAll2() throws SQLException {
		List<ArrestDayDTO> list = dao.getSelectAll2();
		if(list == null || list.isEmpty()) {
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return list;
	}

	@Override
	public List<String> CallMidCrime(String name) throws SQLException {
		
		List<String> list = dao.CallMidCrime(name);
		if(list == null || list.isEmpty()) {
			throw new SQLException("잘못된 키워드 입력, 검색된 레코드가 없습니다.");
		}
		return list;
	}
	 
	
	@Override
	public CrimeInfoDTO SearchOccur(String str) throws SQLException {
		CrimeInfoDTO occur = dao.SearchOccur(str);
		if(occur == null)
			throw new SQLException("잘못된 키워드 입력, 검색된 레코드가 없습니다.");
		
		return occur;
	}
	@Override
	public ArrestDayDTO SearchArrest(String str) throws SQLException {
		ArrestDayDTO arrest = dao.SearchArrest(str);
		if(arrest == null)
			throw new SQLException("잘못된 키워드 입력, 검색된 레코드가 없습니다.");
		
		return arrest;
	}
	
	
	/////////////////
	
	
	@Override
	public int managerUpdate(String name,String comments) throws SQLException {
		 int result = dao.managerUpdate(name,comments);
		 if(result==0)throw new SQLException("수정되지 않았습니다.");
		 return result;
	}
	@Override
	public int managerUpdate2(String name,String comments) throws SQLException {
		 int result = dao.managerUpdate2(name,comments);
		 if(result==0)throw new SQLException("수정되지 않았습니다.");
		 return result;
	}

	@Override
	public boolean PWCheck(String password) throws Exception {
		return new PwUtil().PWCheck(password);
	}

	
}
