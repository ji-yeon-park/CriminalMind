package com.kosta.dto;

public class CrimeInfoDTO {


	private String supercrime; // ��з�
	private int occur_no; // �߻�Ƚ�� 
	private int arrest_no; // �˰�Ƚ�� 
	private String comment; // ó������(�ڸ�Ʈ)

	public CrimeInfoDTO() {}
	
	public CrimeInfoDTO(String supercrime, int occur_no, int arrest_no, String comment) {
		super();
		this.supercrime = supercrime;
		this.occur_no = occur_no;
		this.arrest_no = arrest_no;
		this.comment = comment;
	}
	/*
	 * getter �� setter
	 */
	public String getSupercrime() {
		return supercrime;
	}
	public void setSupercrime(String supercrime) {
		this.supercrime = supercrime;
	}
	public int getOccur() {
		return occur_no;
	}
	public void setOccur(int occur_no) {
		this.occur_no = occur_no;
	}
	public int getArrest() {
		return arrest_no;
	}
	public void setArrest(int arrest_no) {
		this.arrest_no = arrest_no;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		System.out.println("===============================================================================================================================");
		System.out.println("���� ��з�\t|�߻�\t\t|�˰�\t\t|COMMENTS");
		System.out.println("===============================================================================================================================");
		
		System.out.println(supercrime + "\t|" + occur_no +"\t\t|"+ this.getArrest() + "\t\t|" + this.getComment() );

		return builder.toString();
		
	}
	
	
}
