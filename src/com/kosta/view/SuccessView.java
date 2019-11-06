package com.kosta.view;

import java.util.List;

import com.kosta.dto.CriminalDTO;

public class SuccessView {
	public SuccessView() {}

	/**
	 * 전체검색
	 */

	public static void successlist(List<CriminalDTO> list) {
		System.out.println(list);
	}

	/**
	 *  Occur 에 사용
	 */
	public static void OccurPrint(int num) {
		System.out.println("찾으시는 정보는 " + num + "번 입니다." );
	}
	/**
	 * Arrest 에 사용 
	 */
	public static void ArrestPrint(int num) {
		System.out.println("찾으시는 정보는 " + num + "일 입니다." );
	}
	/**
	 * 등록, 수정, 삭제에 따른 성공 메세지 출력
	 */
	public static void printMessage(String message) {
		System.out.println(message);
		
	}


}
