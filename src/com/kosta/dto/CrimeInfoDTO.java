package com.kosta.dto;

public class CrimeInfoDTO {


	private String supercrime; // 대분류
	private int occur_no; // 발생횟수 
	private int arrest_no; // 검거횟수 
	private String comment; // 처벌내용(코멘트)

	public CrimeInfoDTO() {}
	
	public CrimeInfoDTO(String supercrime, int occur_no, int arrest_no, String comment) {
		super();
		this.supercrime = supercrime;
		this.occur_no = occur_no;
		this.arrest_no = arrest_no;
		this.comment = comment;
	}
	/*
	 * getter 와 setter
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
		System.out.println("범죄 대분류\t|발생\t\t|검거\t\t|COMMENTS");
		System.out.println("===============================================================================================================================");
		
		System.out.println(supercrime + "\t|" + occur_no +"\t\t|"+ this.getArrest() + "\t\t|" + this.getComment() );

		return builder.toString();
		
	}
	
	
}
