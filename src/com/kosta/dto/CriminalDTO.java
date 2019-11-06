package com.kosta.dto;

public class CriminalDTO {

	private String id; // �����ڵ�
	private String supercrime; // ��з�
	private String midcrime; // �ߺз�
	private int occur_no; // �߻�Ƚ�� 
	private int arrest_no; // �˰űⰣ 
	private String comment; // ó������(�ڸ�Ʈ)

	public CriminalDTO() {}
	public CriminalDTO(String id, String supercrime, String midcrime) { // �ڵ� ��ġ�Ҷ� ������ ��� 
		super();
		this.id = id;
		this.supercrime = supercrime;
		this.midcrime = midcrime;
	}


	public CriminalDTO(String id, String supercrime, String midcrime, String comment) { // ������Ʈ, ������ ������ ��� 
		this(id, supercrime, midcrime);
		this.comment = comment;
	}
	
	public CriminalDTO(String id, String supercrime, String midcrime, int occur_no, int arrest_no) { // ��ü�˻� ���
		this(id, supercrime, midcrime);
		this.occur_no = occur_no;
		this.arrest_no = arrest_no;
	}
	
	/*
	 * getter �� setter
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		builder.append("CriminalDTO [crimecode=");
		builder.append(id);
		builder.append(", supercrime=");
		builder.append(supercrime);
		builder.append(", midcrime=");
		builder.append(midcrime);
		builder.append(", occur_no=");
		builder.append(occur_no);
		builder.append(", arrest_no=");
		builder.append(arrest_no);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		builder.append("\n");
		return builder.toString();
		
	}
	
	
}
