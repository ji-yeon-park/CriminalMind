package com.kosta.view;

import java.util.List;

import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;

public class SuccessView {
	public SuccessView() {}

	/**
	 * ��ü�˻�
	 */


	public static void successlistAll(List<CrimeInfoDTO> list) {
		int i = 1;
		System.out.println("===============================================================================================================================");
		System.out.println("���� ��з�\t|�߻�\t\t|�˰�");
		System.out.println("===============================================================================================================================");
		
		for(CrimeInfoDTO crime : list) {
			if(i==8) System.out.println(i+"."+crime.getSupercrime() + "\t\t|" + crime.getOccur() +"\t\t| "+ crime.getArrest());
			//�ӽ÷�..
			else System.out.println(i+"."+crime.getSupercrime() + "\t|" + crime.getOccur() +"\t\t| "+ crime.getArrest());

			i++;
		}
	}
	

	public static void successlistAll2(List<ArrestDayDTO> list) {
		int i = 1;
		System.out.println("===============================================================================================================================");
		System.out.println("���� ��з�\t|���� �ߺз�      \t|1���̳�\t|1�����̳�\t|1���̳�\t|1���ʰ�");
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
	 *  Occur �� ���
	 */
	public static void OccurPrint(CrimeInfoDTO num) {
		System.out.println(num);
	}
	/**
	 * Arrest �� ��� 
	 */
	public static void ArrestPrint(ArrestDayDTO num) {
		System.out.println(num);
	}
	/**
	 * ���, ����, ������ ���� ���� �޼��� ���
	 */
	public static void printMessage(String message) {
		System.out.println(message);
		
	}


}
