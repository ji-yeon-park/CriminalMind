package com.kosta.dao;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;


public interface CriminalDAO {

	/**
	 * 전체레코드 검색
	 * list로 리턴
	 */
	List<CrimeInfoDTO> getSelectAll() throws SQLException;
	
	List<ArrestDayDTO> getSelectAll2() throws SQLException;
	
	/**
	 * 중분류범죄명 검색
	 */
	List<String> CallMidCrime(String str) throws SQLException;
	
	/**
	 * 범죄별 발생횟수 검색
	 */
	CrimeInfoDTO SearchOccur(String str) throws SQLException;
	
	
	/**
	 * 범죄별 검거기간 검색 
	 */
	ArrestDayDTO SearchArrest(String str) throws SQLException;
	
	/**
	 * 수정하기 
	 * 범죄코드에 해당하는 코멘트 수정
	 */
	int managerUpdate(String name, String comments) throws SQLException;
	int managerUpdate2(String name, String comments) throws SQLException;
	

}
