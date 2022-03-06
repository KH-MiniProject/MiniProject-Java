package com.test;

public class Test {
	public static void main(String[] args) {
		Test pizza = new Test();
		pizza.order();
	}
	
	private void order() {
		
		String orderMenu = "안녕하세요 @@@ 피자 입니다 ^_^\n"
				+ "================== 피자 주문 프로그램 ==================\n"
				+ "1. 메뉴판\n"
				+ "2. 전체 출력\n" // 정렬 카테고리 정한 후 카테고리별로 정리
				+ "3. 결제\n" // 포장 주문 배달 주문
				+ "===================================================\n"
				+ "> 메뉴 선택";
		
		// 메뉴판
		String pizzaMenu = "안녕하세요 @@@ 피자 입니다 ^_^\n"
				+ "================== 피자 주문 프로그램 ==================\n"
				+ "1. 피자 세트 메뉴\n" 
				+ "2. 피자 단품 메뉴\n"
				+ "3. 사이드 메뉴\n"
				+ "4. 음료 메뉴\n"
				+ "5. 소스 메뉴\n"
				+ "===================================================\n"
				+ "> 메뉴 선택";
		
		// 결제
		String paymentMenu = "\"안녕하세요 @@@ 피자 입니다 ^_^\n"
				+ "================== 피자 주문 프로그램 ==================\n"
				+ "1. 포장 주문\n"
				+ "2. 배달 주문\n"
				+ "===================================================\n"
				+ "> 메뉴 선택";
	}
	
//	public void printCart() {
//		String topStr = "============================== 당신의 장바구니 ==============================\n";
//		String underStr = "-------------------------------------------------------------------------\n"
//				+ "1. 메뉴제외\t\t2.주문량 수정\t\t3.주문확정\t\t4.뒤로가기\n"
//				+ "=========================================================================\n";
//
//		System.out.print(topStr);
//
//		if (isCartEmpty() != true) {
//			// 메뉴와 수량 출력
//			Set<Map.Entry<Menu, Integer>> menuEntrySet = myCart.getMenuCountMap().entrySet();
//			for (Map.Entry<Menu, Integer> menuEntry : menuEntrySet) {
//				Menu key = menuEntry.getKey();
//				int count = (int) menuEntry.getValue();
//
//				String storeName = "";
//				Set<Map.Entry<String, Store>> storeEntrySet = storeMap.entrySet();
//				for (Map.Entry<String, Store> storeEntry : storeEntrySet) {
//					// 매장목록 안의 storeID와 카트 내 메뉴의 storeID가 일치하면
//					if (storeEntry.getKey().equals(key.getStoreID())) {
//						storeName = storeEntry.getValue().getStoreName();
//					}
//				}
//
//				System.out.printf("[%s]\t%8s\t%d개\t%d원\n", storeName, key.getMenuName(), count, key.getPrice() * count);
//			}
//			// 총액 출력
//			System.out.println("합계금액: " + myCart.getTotalPrice());
//		}
//		System.out.print(underStr);
//	}
}
