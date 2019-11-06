package com.kosta.view;

import java.util.List;

import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;

public class SuccessView {
	public SuccessView() {}

	/**
	 * 전체검색
	 */


	public static void successlistAll(List<CrimeInfoDTO> list) {
		int i = 1;
		for(CrimeInfoDTO crime : list) {
			System.out.println("\t" + i+"."+crime.getSupercrime() + "|" + crime.getOccur() +" | "+ crime.getArrest());
			i++;
		}
	}
	

	public static void successlistAll2(List<ArrestDayDTO> list) {
		int i = 1;
		for(ArrestDayDTO crime : list) {
			System.out.println("\t" + i+"."+crime.getSupercrime() +" | "+crime.getMidcrime() +" | "+ crime.getOneD() +" | "+ crime.getOneM() +" | "+ crime.getOneY() +" | "+ crime.getYs());
			i++;
		}
	}
	
	public static void successlist(List<String> list) {
		int i = 1;
		for(String str : list) {
			System.out.println("\t" + i+"."+str);
			i++;
		}
	}

	/**
	 *  Occur 에 사용
	 */
	public static void OccurPrint(CrimeInfoDTO num) {
		System.out.println(num);
	}
	/**
	 * Arrest 에 사용 
	 */
	public static void ArrestPrint(ArrestDayDTO num) {
		System.out.println(num);
	}
	/**
	 * 등록, 수정, 삭제에 따른 성공 메세지 출력
	 */
	public static void printMessage(String message) {
		System.out.println(message);
		
	}


}
