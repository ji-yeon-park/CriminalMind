package com.kosta.dto;

public class ArrestDayDTO {

	private String supercrime;
	private String midcrime;
	private int oneD;
	private int oneM;
	private int oneY;
	private int ys;
	private String comments;
	
	public ArrestDayDTO() {
	}
	
	public ArrestDayDTO(String supercrime, String midcrime, int oneD, int oneM, int oneY, int ys, String comments) {
		super();
		this.supercrime = supercrime;
		this.midcrime = midcrime;
		this.oneD = oneD;
		this.oneM = oneM;
		this.oneY = oneY;
		this.ys = ys;
		this.comments = comments;
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
	public int getOneD() {
		return oneD;
	}
	public void setOneD(int oneD) {
		this.oneD = oneD;
	}
	public int getOneM() {
		return oneM;
	}
	public void setOneM(int oneM) {
		this.oneM = oneM;
	}
	public int getOneY() {
		return oneY;
	}
	public void setOneY(int oneY) {
		this.oneY = oneY;
	}
	public int getYs() {
		return ys;
	}
	public void setYs(int ys) {
		this.ys = ys;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArrestDayDTO [supercrime=");
		builder.append(supercrime);
		builder.append(", midcrime=");
		builder.append(midcrime);
		builder.append(", oneD=");
		builder.append(oneD);
		builder.append(", oneM=");
		builder.append(oneM);
		builder.append(", oneY=");
		builder.append(oneY);
		builder.append(", ys=");
		builder.append(ys);
		builder.append(", comments=");
		builder.append(comments);
		builder.append("]");
		return builder.toString();
	}


}