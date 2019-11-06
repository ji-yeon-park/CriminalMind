package com.kosta.dto;

public class CriminalDTO {

	private int crimecode; // 범죄코드
	private String supercrime; // 대분류
	private String midcrime; // 중분류
	private int occur; // 발생횟수 
	private int arrest; // 검거기간 
	private String comment; // 처벌내용(코멘트)

	public CriminalDTO() {}
	public CriminalDTO(int crimecode, String supercrime, String midcrime) { // 코드 서치할때 나오는 결과 
		super();
		this.crimecode = crimecode;
		this.supercrime = supercrime;
		this.midcrime = midcrime;
	}


	public CriminalDTO(int crimecode, String supercrime, String midcrime, String comment) { // 업데이트, 삭제때 나오는 결과 
		this(crimecode, supercrime, midcrime);
		this.comment = comment;
	}
	
	public CriminalDTO(int crimecode, String supercrime, String midcrime, int occur, int arrest) { // 전체검색 결과
		this(crimecode, supercrime, midcrime);
		this.occur = occur;
		this.arrest = arrest;
	}
	
	/*
	 * getter 와 setter
	 */
	public int getCrimecode() {
		return crimecode;
	}
	public void setCrimecode(int crimecode) {
		this.crimecode = crimecode;
	}
	public String getSupercrime() {
		return supercrime;
	}
	public void setSupercrime(String supercrime) {
		this.supercrime = supercrime;
	}
	public String getMidcrime() {
		return midcrime;
	}
	public void setMidcrime(String midcrime) {
		this.midcrime = midcrime;
	}
	public int getOccur() {
		return occur;
	}
	public void setOccur(int occur) {
		this.occur = occur;
	}
	public int getArrest() {
		return arrest;
	}
	public void setArrest(int arrest) {
		this.arrest = arrest;
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
		builder.append("CriminalDTO [crimecode=");
		builder.append(crimecode);
		builder.append(", supercrime=");
		builder.append(supercrime);
		builder.append(", midcrime=");
		builder.append(midcrime);
		builder.append(", occur=");
		builder.append(occur);
		builder.append(", arrest=");
		builder.append(arrest);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		return builder.toString();
	}
	
	
}
