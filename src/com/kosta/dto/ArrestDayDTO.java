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
		System.out.println("===============================================================================================================================");
		System.out.println("범죄 대분류\t|범죄 중분류      \t|1일이내\t|1개월이내\t|1년이내\t|1년초과");
		System.out.println("===============================================================================================================================");
		System.out.println(this.getSupercrime() + "\t|" +this.getMidcrime() +"   \t\t|"+ this.getOneD() +"\t\t|"+ this.getOneM() +"\t\t|"+ this.getOneY() +"\t\t|"+ this.getYs());
		return builder.toString();
	}


}