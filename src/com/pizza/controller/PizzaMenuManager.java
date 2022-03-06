package com.pizza.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.pizza.model.vo.PizzaMenu;

public class PizzaMenuManager {
	
	private Scanner sc = new Scanner(System.in);
	boolean bool = true;
	
	private List<PizzaMenu> setMenu = new ArrayList();
	private List<PizzaMenu> singleMenu = new ArrayList();
	private List<PizzaMenu> sideMenu = new ArrayList();
	private List<PizzaMenu> drinkMenu = new ArrayList();
	private List<PizzaMenu> sauceMenu = new ArrayList();
	private List<PizzaMenu> cart = new ArrayList();
	
	public PizzaMenuManager() {
		setMenu.add(new PizzaMenu("1","세트","A 세트 (불고기피자 + 치킨텐더 + 콜라)",100000));
		setMenu.add(new PizzaMenu("2","세트","B 세트 (페퍼로니피자 + 웨지감자 + 콜라)",100000));
		setMenu.add(new PizzaMenu("3","세트","C 세트 (콤비네이션피자 + 버팔로윙 + 콜라)",100000));
		setMenu.add(new PizzaMenu("4","세트","D 세트 (포테이토피자 + 버팔로윙 + 콜라)",100000));
		setMenu.add(new PizzaMenu("5","세트","E 세트 (치즈피자 + 스파게티 + 콜라)",100000));
	
		singleMenu.add(new PizzaMenu("1","단품","불고기피자			",100000));
		singleMenu.add(new PizzaMenu("2","단품","페퍼로니피자		",100000));
		singleMenu.add(new PizzaMenu("3","단품","콤비네이션피자		",100000));
		singleMenu.add(new PizzaMenu("4","단품","포테이토피자		",100000));
		singleMenu.add(new PizzaMenu("5","단품","치즈피자			",100000));
	
		sideMenu.add(new PizzaMenu("1","사이드","치킨 텐더			",100000));
		sideMenu.add(new PizzaMenu("2","사이드","웨지 감자			",100000));
		sideMenu.add(new PizzaMenu("3","사이드","버팔로 윙			",100000));
		sideMenu.add(new PizzaMenu("4","사이드","스파게티			",100000));
		sideMenu.add(new PizzaMenu("5","사이드","치즈 볼			",100000));
	
		drinkMenu.add(new PizzaMenu("1","음료","코카콜라			",100000));
		drinkMenu.add(new PizzaMenu("2","음료","사이다			",100000));
		drinkMenu.add(new PizzaMenu("3","음료","환타			",100000));
		drinkMenu.add(new PizzaMenu("4","음료","제로 코카콜라			",100000));
		
		sauceMenu.add(new PizzaMenu("1","소스","핫소스			",100000));
		sauceMenu.add(new PizzaMenu("2","소스","갈릭소스			",100000));
		sauceMenu.add(new PizzaMenu("3","소스","머스타드소스		",100000));
	}
	
	public PizzaMenuManager(List<PizzaMenu> setMenu, List<PizzaMenu> singleMenu,
			List<PizzaMenu> sideMenu, List<PizzaMenu> drinkMenu, List<PizzaMenu> sauceMenu) {
		this.setMenu = setMenu;
		this.singleMenu = singleMenu;
		this.sideMenu = sideMenu;
		this.drinkMenu = drinkMenu;
		this.sauceMenu = sauceMenu;
	}
	
	public void AddSetMenu(String choiceSetMenu) {
		switch(choiceSetMenu) {
		case "1" :
			System.out.println("A 세트 추가 !");
			cart.add(new PizzaMenu("1","세트","A 세트 (불고기피자 + 치킨텐더 + 콜라)",100000));
			break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void AddSigleMenu(String choiceSingleMenu) {
		switch(choiceSingleMenu) {
		case "1" :
			System.out.println("A 세트 추가 !");
			cart.add(new PizzaMenu("1","단품","불고기피자",100000));
			break;
		case "2" : break;
		case "3" : break;
		case "4" : break;
		case "5" : break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void AddSideMenu(String choiceSideMenu) {
		switch(choiceSideMenu) {
		case "1" : break;
		case "2" : break;
		case "3" : break;
		case "4" : break;
		case "5" : break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void AddDrinkMenu(String choiceDrinkMenu) {
		switch(choiceDrinkMenu) {
		case "1" : break;
		case "2" : break;
		case "3" : break;
		case "4" : break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void AddSauceMenu(String choiceSauceMenu) {
		switch(choiceSauceMenu) {
		case "1" : break;
		case "2" : break;
		case "3" : break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
		
	}
	
	public void PrintCart() {
		for(int i = 0; i < cart.size(); i++) {
			System.out.println(cart.get(i));
		}
	}
	
	public void fileSave() {
		int cartListSize = cart.size();
		PizzaMenu arr[] = cart.toArray(new PizzaMenu[cartListSize]);
		
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream("pizza.txt")));) {
			oos.writeObject(arr);
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
		System.out.println("pizza.txt 에 저장 완료!");
	}
	
	public void fileRead() {
		try(ObjectInputStream ois = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream("pizza.txt")));) {

			int cartListSize = cart.size();
			PizzaMenu arr[] = (PizzaMenu[]) ois.readObject();
			
			for(PizzaMenu pizzas : arr) {
				System.out.println(pizzas);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("pizza.txt 읽기 완료!");
	}

}
