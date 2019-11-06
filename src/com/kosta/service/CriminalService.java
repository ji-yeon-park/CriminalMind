package com.kosta.service;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;


public interface CriminalService {

	/**
	 * 전체레코드 검색
	 * list로 리턴
	 */
	List<CrimeInfoDTO> SelectAll() throws SQLException;
	
	List<ArrestDayDTO> SelectAll2() throws SQLException;
	
	/**
	 * 중분류 범죄종류 검색 
	 */
	List<String> CallMidCrime(String name) throws SQLException;
	
	
	/**
	 * 범죄별 발생횟수 검색
	 */
	CrimeInfoDTO SearchOccur(String supercime) throws SQLException;
	/**
	 * 범죄별 검거기간 검색 
	 */
	ArrestDayDTO SearchArrest(String midcrime) throws SQLException;
	
	/**
	 * 수정하기 
	 * 범죄코드에 해당하는 코멘트 수정
	 */
	int managerUpdate(String name,String comments) throws SQLException;
	int managerUpdate2(String name,String comments) throws SQLException;
	
	/** 비밀번호 검증
	 * 비밀번호를 property파일과 비교하고 3회이상 틀릴시 프로그램을 종료
	 */
	boolean PWCheck (String password) throws Exception;
}
