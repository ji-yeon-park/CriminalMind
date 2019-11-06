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
	 * 범죄별 발생횟수 검색
	 */
	int SearchOccur(String supercrime) throws SQLException;
	
	
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
	int managerDelete(int code) throws SQLException;
	
	
}
