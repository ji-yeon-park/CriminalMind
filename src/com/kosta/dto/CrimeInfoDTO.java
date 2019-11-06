package com.kosta.dto;

public class CrimeInfoDTO {


	private String supercrime; // ´ëºÐ·ù
	private int occur_no; // ¹ß»ýÈ½¼ö 
	private int arrest_no; // °Ë°ÅÈ½¼ö 
	private String comment; // Ã³¹ú³»¿ë(ÄÚ¸àÆ®)

	public CrimeInfoDTO() {}
	
	public CrimeInfoDTO(String supercrime, int occur_no, int arrest_no, String comment) {
		super();
		this.supercrime = supercrime;
		this.occur_no = occur_no;
		this.arrest_no = arrest_no;
		this.comment = comment;
	}
	/*
	 * getter ¿Í setter
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
		builder.append("CriminalDTO [");
		builder.append("supercrime=");
		builder.append(supercrime);
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
