package com.pizza.model.vo;

public class ToppingMenu {
	
	private String tno; // 토핑 번호
	private String title; // 토핑 이름
	private int price; // 토핑 가격
	
	public ToppingMenu() {}

	public ToppingMenu(String tno, String title, int price) {
		super();
		this.tno = tno;
		this.title = title;
		this.price = price;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return tno + title + price;
	}
	

}
