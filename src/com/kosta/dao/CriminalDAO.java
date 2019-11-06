package com.kosta.dao;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.CriminalDTO;

public interface CriminalDAO {

	/**
	 * 전체레코드 검색
	 * list로 리턴
	 */
	List<CriminalDTO> getSelectAll() throws SQLException;
	
	/**
	 * 중분류범죄명 검색
	 */
	List<CriminalDTO> CallMidCrime(String str) throws SQLException;
	
	/**
	 * 범죄별 발생횟수 검색
	 */
	int SearchOccur(int number) throws SQLException;
	
	
	/**
	 * 범죄별 검거기간 검색 
	 */
	int SearchArrest(String midcrime) throws SQLException;
	
	/**
	 * 수정하기 
	 * 범죄코드에 해당하는 코멘트 수정
	 */
	int managerUpdate(CriminalDTO criminalDTO) throws SQLException;
	
	
	/**
	 * 삭제하기 
	 * 범죄코드에 해당하는 코멘트 삭제 
	 */
	int managerDelete(String id) throws SQLException;
	
	
}
