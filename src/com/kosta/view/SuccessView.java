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
		System.out.println("===============================================================================================================================");
		System.out.println("범죄 대분류\t|발생\t\t|검거");
		System.out.println("===============================================================================================================================");
		
		for(CrimeInfoDTO crime : list) {
			if(i==8) System.out.println(i+"."+crime.getSupercrime() + "\t\t|" + crime.getOccur() +"\t\t| "+ crime.getArrest());
			//임시로..
			else System.out.println(i+"."+crime.getSupercrime() + "\t|" + crime.getOccur() +"\t\t| "+ crime.getArrest());

			i++;
		}
	}
	

	public static void successlistAll2(List<ArrestDayDTO> list) {
		int i = 1;
		System.out.println("===============================================================================================================================");
		System.out.println("범죄 대분류\t|범죄 중분류      \t|1일이내\t|1개월이내\t|1년이내\t|1년초과");
		System.out.println("===============================================================================================================================");
		
		for(ArrestDayDTO crime : list) {
			if(i==7||i==23||i==29) System.out.println(i+"."+crime.getSupercrime() + "\t|" +crime.getMidcrime() +"   \t|"+ crime.getOneD() +"\t\t|"+ crime.getOneM() +"\t\t|"+ crime.getOneY() +"\t\t|"+ crime.getYs());
			else System.out.println(i+"."+crime.getSupercrime() + "\t|" +crime.getMidcrime() +"   \t\t|"+ crime.getOneD() +"\t\t|"+ crime.getOneM() +"\t\t|"+ crime.getOneY() +"\t\t|"+ crime.getYs());
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
