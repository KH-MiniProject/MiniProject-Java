package com.pizza.model.vo;

import java.io.Serializable;

public class PizzaMenu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pNo;     // 메뉴 번호
	private String category;    // 카테고리
	private String title;    // 메뉴 이름
	private int price;        // 가격
	private int count = 0;	// 수량
	
	
	public PizzaMenu() {}
	
	public PizzaMenu(String pNo, String category, String title, int price) {
		super();
		this.pNo = pNo;
		this.category = category;
		this.title = title;
		this.price = price;
	}
	
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
		return pNo +"\t"+ category +"\t"+ title +"\t"+ price;
	}
}
