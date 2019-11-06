package com.kosta.dto;

public class CriminalDTO {

	private int crimecode; // �����ڵ�
	private String supercrime; // ��з�
	private String midcrime; // �ߺз�
	private int occur; // �߻�Ƚ�� 
	private int arrest; // �˰űⰣ 
	private String comment; // ó������(�ڸ�Ʈ)

	public CriminalDTO() {}
	public CriminalDTO(int crimecode, String supercrime, String midcrime) { // �ڵ� ��ġ�Ҷ� ������ ��� 
		super();
		this.crimecode = crimecode;
		this.supercrime = supercrime;
		this.midcrime = midcrime;
	}


	public CriminalDTO(int crimecode, String supercrime, String midcrime, String comment) { // ������Ʈ, ������ ������ ��� 
		this(crimecode, supercrime, midcrime);
		this.comment = comment;
	}
	
	public CriminalDTO(int crimecode, String supercrime, String midcrime, int occur, int arrest) { // ��ü�˻� ���
		this(crimecode, supercrime, midcrime);
		this.occur = occur;
		this.arrest = arrest;
	}
	
	/*
	 * getter �� setter
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
