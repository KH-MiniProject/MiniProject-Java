package com.pizza.view;

import java.util.Scanner;

import com.pizza.controller.PizzaMenuManager;
import com.pizza.model.vo.PizzaMenu;

public class PizzaMenuView {
	
	private PizzaMenuManager pmm = new PizzaMenuManager();
	Scanner sc = new Scanner(System.in);

	private String choiceSetMenu;
	private String choiceSingleMenu;
	private String choiceSideMenu;
	private String choiceDrinkMenu;
	private String choiceSauceMenu;
	
	private boolean bool = true;
	int priceTotal = 0;
	
	public void PizzaMenu() {
		String strPizzaMenu = "==========================================================\n"
							+ "                            메뉴                           \n"
							+ "==========================================================\n"
							+ "1. 메뉴 선택\n"
							+ "2. 주문\n"
							+ "0. 프로그램 종료\n"
							+ "==========================================================\n"
							+ ">> ";
		outer:
		while(bool) {
			System.out.print(strPizzaMenu);
			String selected = sc.next();

			switch(selected) {
			case "1": PizzaMenuList(); break; 
			case "6": OrderMenu(); break;
			case "0": System.out.print("프로그램 종료 !"); break outer;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void PizzaMenuList() {
		String strMenuList = "==========================================================\n"
						   + "                         메뉴 목록                           \n"
						   + "==========================================================\n"
						   + "1. 세트\n"
						   + "2. 단품\n"
						   + "3. 사이드\n"
						   + "4. 음료\n"
						   + "5. 소스\n"
						   + "6. 주문\n"
						   + "7. 테스트 출력\n"
						   + "0. 이전 메뉴로 돌아가기\n"
						   + "==========================================================\n"
						   + ">> ";
		
		while(bool) {
			System.out.print(strMenuList);
			String menuSelected = sc.next();
			
			switch(menuSelected) {
			case "1": pmm.AddSetMenu(SetMenu()); break;
			case "2": pmm.AddSigleMenu(SingleMenu()); break;
			case "3": pmm.AddSideMenu(SideMenu()); break;
			case "4": pmm.AddDrinkMenu(DrinkMenu()); break;
			case "5": pmm.AddSauceMenu(SauceMenu()); break;
			case "6": OrderMenu(); break;
			case "7": pmm.SortCart(); pmm.PrintCart(); /*pmm.PrintCount();*/ break; // 테스트 출력
			case "0": return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void OrderMenu() {
		String strOrderMenu1 = "==========================================================\n"
							 + "                          장바구니                           \n"
							 + "==========================================================\n"
							 + "카테고리\t메뉴이룸\t가격\t  \t";
		
		String strOrderMenu2 = "총 가격 : ";
		
		String strOrderMenu3 = "==========================================================\n";
		
		String strOrderMenu4 = "==========================================================\n"
							 + "1. 메뉴 추가\n"
							 + "2. 메뉴 삭제\n"
							 + "3. 결제하기\n"
							 + "0. 이전 메뉴로 돌아가기\n"
							 + "==========================================================\n"
							 + ">> ";
		
		while(bool) {
			System.out.print(strOrderMenu1);
			System.out.print(strOrderMenu2);
			pmm.TotalPirce();
			System.out.print(strOrderMenu3);
			pmm.PrintCart();
			System.out.println(strOrderMenu4);
			String OrderSelected = sc.next();
			
			switch(OrderSelected) {
			case "1" : PizzaMenuList(); break;
			case "2" : removeCart(); break; // 구현 예정
			case "3" : PaymentMenu(); break;
			case "9" : break;
			case "0" : return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void removeCart() {
	      boolean result = false;
	      result = pmm.removeCart(inputTitle());
	      System.out.println(result ? "> 삭제 성공!" : "> 삭제 실패! 찾으시는 메뉴가 없습니다.");
	}
	
	public String inputTitle() {
		System.out.println("메뉴 이름을 입력하세요 : ");
		return sc.next();
	}
	
	public void PaymentMenu() {
		String strPaymentMenu = "==========================================================\n"
							   + "                        주문 방식 선택                        \n"
							   + "==========================================================\n"
							   + "1. 포장 주문 (포장 할인 적용)\n"
							   + "2. 배달 주문 (배달 비용 추가)\n"
							   + "3. 장바구니 확인\n"
							   + "9. 이전 메뉴로 돌아가기\n"
							   + "0. 프로그램 종료\n"
							   + "==========================================================\n"
							   + ">> ";
		
		while(bool) {
			System.out.print(strPaymentMenu);
			String choice = sc.next();
			sc.nextLine();
			
			switch(choice) {
			case "1" : // 포장 주문
				System.out.println("포장 주문을 선택하셨습니다.");
				pmm.PrintCart();
				orderCheckPacking();
				break;
			case "2" : // 배달 주문
				System.out.println("배달 주문을 선택하셨습니다.");
				pmm.PrintCart();
				orderCheckDeliver();
				break;
			case "3" : 
				OrderMenu();
				break;
			case "9" :
				return;
			case "0" : // 주문 취소
				System.out.println("주문이 취소되었습니다.");
				bool = false;
				return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	private void orderCheckPacking() {
		String orderCheckMenu1 = "==========================================================\n"
							   + "                          주문 확인서                         \n"
							   + "===========================================================\n"
							   + "카테고리\t메뉴이룸\t가격\t / \t";
		String orderCheckMenu2 = "총 가격 : ";
		String orderCheckMenu3 = "==========================================================\n";
		String orderCheckMenu4 = "1. 주문 하기\n"
							   + "0. 주문 취소\n"
							   + "==========================================================\n"
							   + ">> ";
		
		
		while(bool) {
			System.out.print(orderCheckMenu1);
			System.out.print(orderCheckMenu2);
			pmm.Packing();
			System.out.print(orderCheckMenu3);
			pmm.PrintCart();
			System.out.println(orderCheckMenu4);
			String choice = sc.next();
			sc.nextLine();
			switch(choice) {
			case "1" : // 주문 하기
				System.out.println("주문 완료 !");
				pmm.fileSave();
				pmm.fileRead();
				bool = false;
				break;
			case "0" : // 주문 취소
				System.out.println("주문이 취소되었습니다.");
				bool = false;
				break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println("프로그램 종료");
		}
	}
	
	private void orderCheckDeliver() {
		String orderCheckMenu1 = "==========================================================\n"
							   + "                          주문 확인서                         \n"
							   + "===========================================================\n"
							   + "카테고리\t메뉴이룸\t가격\t / \t";
		String orderCheckMenu2 = "총 가격 : ";
		String orderCheckMenu3 = "==========================================================\n";
		String orderCheckMenu4 = "1. 주문 하기\n"
							   + "0. 주문 취소\n"
							   + "==========================================================\n"
							   + ">> ";
		
		
		while(bool) {
			System.out.print(orderCheckMenu1);
			System.out.print(orderCheckMenu2);
			pmm.Deliver();
			System.out.print(orderCheckMenu3);
			pmm.PrintCart();
			System.out.println(orderCheckMenu4);
			String choice = sc.next();
			sc.nextLine();
			switch(choice) {
			case "1" : // 주문 하기
				System.out.println("주문 완료 !");
				pmm.fileSave();
				pmm.fileRead();
				bool = false;
				break;
			case "0" : // 주문 취소
				System.out.println("주문이 취소되었습니다.");
				bool = false;
				break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println("프로그램 종료");
		}
	}
	
	public String SetMenu() {
		String strSetMenu = "==========================================================\n"
						   + "                         세트 메뉴                           \n"
						   + "==========================================================\n"
						   + "1. A세트 (불고기 피자 + 치킨텐더 + 콜라)--------------------30,000원\n"
						   + "2. B세트 (페퍼로니 피자 + 웨지감자 + 콜라)-------------------40,000원\n"
						   + "3. C세트 (콤비네이션 피자 + 버팔로윙 + 콜라)------------------50,000원\n"
						   + "4. D세트 (포테이토피자 + 버팔로윙 + 콜라)--------------------60,000원\n"
						   + "5. E세트 (치즈피자 + 스파게티 + 콜라)----------------------70,000원\n"
						   + "==========================================================\n"
						   + "0. 이전 메뉴로 돌아가기\n"
						   + "==========================================================\n"
						   + ">> ";
		
		System.out.println(strSetMenu);
		choiceSetMenu = sc.next();
		
		return choiceSetMenu;
	}
	
	public String SingleMenu() {
		String strSingleMenu = "==========================================================\n"
							   + "                         단품 메뉴                           \n"
							   + "==========================================================\n"
							   + "1. 불고기 피자---------------------------------------30,000원\n"
							   + "2. 페퍼로니 피자--------------------------------------40,000원\n"
							   + "3. 콤비네이션 피자-------------------------------------50,000원\n"
							   + "4. 포테이토 피자--------------------------------------60,000원\n"
							   + "5. 치즈 피자-----------------------------------------70,000원\n"
							   + "==========================================================\n"
							   + "0. 이전 메뉴로 돌아가기\n"
							   + "==========================================================\n"
							   + ">> ";
		
		System.out.println(strSingleMenu);
		choiceSingleMenu = sc.next();
		
		return choiceSingleMenu;
	}
	
	public String SideMenu() {
		String strSideMenu = "==========================================================\n"
						   + "                        사이드 메뉴                           \n"
						   + "==========================================================\n"
						   + "1. 치킨 텐더-----------------------------------------30,000원\n"
						   + "2. 웨지 감자-----------------------------------------40,000원\n"
						   + "3. 버팔로 윙-----------------------------------------50,000원\n"
						   + "4. 오븐 스파게티---------------------------------------60,000원\n"
						   + "5. 치즈볼--------------------------------------------70,000원\n"
						   + "==========================================================\n"
						   + "0. 이전 메뉴로 돌아가기\n"
						   + "==========================================================\n"
						   + ">> ";
		
		System.out.println(strSideMenu);
		choiceSideMenu = sc.next();
		
		return choiceSideMenu;
	}
	
	public String DrinkMenu() {
		String strDrinkMenu = "==========================================================\n"
						   + "                         음료 메뉴                           \n"
						   + "==========================================================\n"
						   + "1. 코카콜라------------------------------------------30,000원\n"
						   + "2. 스프라이트-----------------------------------------40,000원\n"
						   + "3. 환타---------------------------------------------50,000원\n"
						   + "4. 제로 코카콜라---------------------------------------60,000원\n"
						   + "==========================================================\n"
						   + "0. 이전 메뉴로 돌아가기\n"
						   + "==========================================================\n"
						   + ">> ";
		
		System.out.println(strDrinkMenu);
		choiceDrinkMenu = sc.next();
		
		return choiceDrinkMenu;
	}
	
	public String SauceMenu() {
		String strSauceMenu = "==========================================================\n"
						   + "                         소스 메뉴                           \n"
						   + "==========================================================\n"
						   + "1. 핫 소스-------------------------------------------30,000원\n"
						   + "2. 갈릭 소스------------------------------------------40,000원\n"
						   + "3. 머스타드 소스----------------------------------------50,000원\n"
						   + "==========================================================\n"
						   + "0. 이전 메뉴로 돌아가기\n"
						   + "==========================================================\n"
						   + ">> ";
		
		System.out.println(strSauceMenu);
		choiceSauceMenu = sc.next();
		
		return choiceSauceMenu;
		
	}
	
	
	
}
