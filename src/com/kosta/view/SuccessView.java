package com.kosta.view;

import java.util.List;

import com.kosta.dto.CriminalDTO;

public class SuccessView {
	public SuccessView() {}

	/**
	 * ��ü�˻�
	 */

	public static void successlist(List<CriminalDTO> list) {
		System.out.println(list);
	}

	/**
	 *  Occur �� ���
	 */
	public static void OccurPrint(int num) {
		System.out.println("ã���ô� ������ " + num + "�� �Դϴ�." );
	}
	/**
	 * Arrest �� ��� 
	 */
	public static void ArrestPrint(int num) {
		System.out.println("ã���ô� ������ " + num + "�� �Դϴ�." );
	}
	/**
	 * ���, ����, ������ ���� ���� �޼��� ���
	 */
	public static void printMessage(String message) {
		System.out.println(message);
		
	}


}
