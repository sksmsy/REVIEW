package step5_test;

import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] money   = {50000, 10000, 5000, 1000, 500, 100};
		int[] charges = {    10,     10,    10,    10,   10,  10};
		
		int tickets = 5;		// 식권 개수
		int price = 3200;		// 식권 가격
		
		while(true) {
			
			System.out.println("[1]관리자");
			System.out.println("[2]사용자");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				while(true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");
					
					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if(choice == 1) {
						System.out.print(" 충전 매수 : ");
						int add = scan.nextInt();
							
						tickets += add;
						
						System.out.println("충전완료");
						
					}
					else if(choice == 2) {
						while(true) {
							
							for (int i = 0; i < charges.length; i++) {
								System.out.println("["+(i+1)+"]"+ money[i] + " : " + charges[i]);
							}
							System.out.println("[0]종료");
							System.out.print("입력 : ");
							int moSel = scan.nextInt();
					
							if(moSel == 0) {
								break;
							}
							
							System.out.print("충전 매수 : ");
							int amount = scan.nextInt();
							
							charges[moSel-1] += amount;
							System.out.println("충전완료");

						}
							
					}
					else if(choice == 3) {
						break;
					}
				}
			}
			else if(sel == 2) {
				while(true) {
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");
					
					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if(choice == 1) {
						System.out.println("잔여식권 : " + tickets);
						System.out.println("식권가격 : " + price);
						
						System.out.print("구입 매수 : ");
						int amount = scan.nextInt();
						
						if(amount > tickets) {
							System.out.println("식권이 부족합니다");
							continue;
						}
						
						int tot = amount * price;
						System.out.println("가격 : " + tot );
						
						int my = 0 ;
						int input[] = new int[6];
						while(true) {
							System.out.println("투입된 금액 : " + my );
							System.out.println("현금 투입");
							System.out.println("[1]5만 [2]1만 [3]5천 [4]1천");
							System.out.println("[5]5백 [6]1백 [0]결제");
							int insert = scan.nextInt();							
							if(insert == 0) {
								break;
							}
							my += money[insert - 1];
							input[insert-1] += 1;
						}
						
						int change = my - tot;
						
						if(my < tot) {
							System.out.println("금액이 부족합니다.");
							continue;
						}
						
						int check_charges [] = charges;
						int check_change = change;
						
						
						for (int i = 0; i < check_charges.length; i++) {
							
							while(true) {
								if(check_change >= money[i] && check_charges[i] >0) {
									check_change -= money[i];
									check_charges[i] -= 1;
									
								}else {
									break;
								}
							}
						}
							
					
						if(check_change == 0) {
							for (int i = 0; i < check_charges.length; i++) {
								charges[i] = check_charges[i];
								charges[i] += input[i];
							}
							
						}else {
							System.out.println("잔돈이 부족합니다. ");
						}

						
						System.out.println("결제금액 : " + tot);
						System.out.println("투입금액 : " + my);
						System.out.println("잔돈 : " );
						
					}
					else if(choice == 2) {
						break;
					}
				}
			}
		}

	}

}
//1555

//1655