package com.pizza.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.pizza.model.vo.PizzaMenu;

public class PizzaMenuManager {
	
	private Scanner sc = new Scanner(System.in);
	boolean bool = true;
	int price = 0;
	int count = 0;
	int totalPrice = 0;
	
	private List<PizzaMenu> cart = new ArrayList();
	
	// 중복 제거 시도
//	private List<PizzaMenu> newCart = cart.stream().distinct().collect(Collectors.toList());
//	private Set<PizzaMenu> set = new HashSet<PizzaMenu>(cart);
//	private List<PizzaMenu> newCart = new ArrayList<PizzaMenu>(set);
	
	PizzaMenu pm = new PizzaMenu();
	
	public void AddSetMenu(String choiceSetMenu) {
		switch(choiceSetMenu) {
	      case "1" :
	          System.out.println("A 세트 추가 !");
	          cart.add(new PizzaMenu("1", "가","세트","A세트",10));
	          price = 10;
	          count ++;
	          totalPrice += 10;
	          break;
	       case "2" :
	          System.out.println("B 세트 추가 !");
	          cart.add(new PizzaMenu("2", "가","세트","B세트",20));
	          price = 20;
	          count ++;
	          totalPrice += 20;
	          break;
	       case "3" :
	          System.out.println("C 세트 추가 !");
	          cart.add(new PizzaMenu("3", "가","세트","C세트",30));
	          price = 30;
	          count ++;
	          totalPrice += 30;
	          break;
	       case "4" :
	          System.out.println("D 세트 추가 !");
	          cart.add(new PizzaMenu("4", "가","세트","D세트",10));
	          price = 10;
	          count ++;
	          totalPrice += 10;
	          break;
	       case "5" :
	          System.out.println("E 세트 추가 !");
	          cart.add(new PizzaMenu("5", "가","세트","E세트",20));
	          price = 20;
	          count ++;
	          totalPrice += price;
	          break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void AddSigleMenu(String choiceSingleMenu) {
		switch(choiceSingleMenu) {
	      case "1" :
	          System.out.println("불고기피자 추가 !");
	          cart.add(new PizzaMenu("1", "나","단품","불고기피자",300000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "2" :
	          System.out.println("페퍼로니피자 추가 !");
	          cart.add(new PizzaMenu("2", "나","단품","페퍼로니피자",400000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "3" :
	          System.out.println("콤비네이션피자 추가 !");
	          cart.add(new PizzaMenu("3", "나","단품","콤비네이션피자",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "4" :
	          System.out.println("포테이토피자 추가 !");
	          cart.add(new PizzaMenu("4", "나","단품","포테이토피자",500000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "5" :
	          System.out.println("치즈피자 추가 !");
	          cart.add(new PizzaMenu("5", "나","단품","치즈피자",600000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void AddSideMenu(String choiceSideMenu) {
		switch(choiceSideMenu) {
	      case "1" :
	          System.out.println("치킨 텐더 추가 !");
	          cart.add(new PizzaMenu("1", "다","사이드","치킨 텐더",200000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "2" :
	          System.out.println("웨지 감자 추가 !");
	          cart.add(new PizzaMenu("2", "다","사이드","웨지 감자",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "3" :
	          System.out.println("버팔로 윙 추가 !");
	          cart.add(new PizzaMenu("3", "다","사이드","버팔로 윙",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "4" :
	          System.out.println("스파게티 추가 !");
	          cart.add(new PizzaMenu("4", "다","사이드","스파게티",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "5" :
	          System.out.println("치즈 볼 추가 !");
	          cart.add(new PizzaMenu("5", "다","사이드","치즈 볼",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void AddDrinkMenu(String choiceDrinkMenu) {
		switch(choiceDrinkMenu) {
	      case "1" :
	          System.out.println("코카콜라 추가 !");
	          cart.add(new PizzaMenu("1", "라","음료","코카콜라",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "2" :
	          System.out.println("사이다 추가 !");
	          cart.add(new PizzaMenu("2", "라","음료","사이다",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "3" :
	          System.out.println("환타 추가 !");
	          cart.add(new PizzaMenu("3", "라","음료","환타",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "4" :
	          System.out.println("제로 코카콜라 추가 !");
	          cart.add(new PizzaMenu("4", "라","음료","제로 코카콜라",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void AddSauceMenu(String choiceSauceMenu) {
		switch(choiceSauceMenu) {
	      case "1" :
	          System.out.println("핫소스 추가 !");
	          cart.add(new PizzaMenu("1", "마","소스","핫소스",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "2" :
	          System.out.println("갈릭소스 추가 !");
	          cart.add(new PizzaMenu("2", "마","소스","갈릭소스",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
	       case "3" :
	          System.out.println("머스타드소스 추가 !");
	          cart.add(new PizzaMenu("3", "마","소스","머스타드소스",100000));
	          price = 100000;
	          count += 1;
	          totalPrice += (count * price);
	          break;
		case "0" : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
		
	}
	
	public void PrintCart() {
		for(int i = 0; i < cart.size(); i++) {
			System.out.println(cart.get(i));
		}
	}
	
	public void SortCart() {
		Collections.sort(cart);
		return;
	}
	
//	public void PrintCount() {
//		System.out.println(pm.getCount());
//	}
	
	public void TotalPirce() {
		System.out.println(totalPrice);
	}
	public void Packing() {
		totalPrice -= 3000;
		System.out.println(totalPrice + "원 포장 할인(3000원) 적용");
	}
	public void Deliver() {
		totalPrice += 3000;
		System.out.println(totalPrice + "원 배달비(3000원) 적용");
	}
	
	public boolean removeCart(String title) {
		for(int i = 0; i < cart.size(); i++) {
	         if(title.equals(cart.get(i).getTitle())) {
	            cart.remove(i); 
	            return true;
	         }
	      }
		return false;
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
