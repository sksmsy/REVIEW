package step4_19;

import java.util.Scanner;

public class FileEx10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] money   = {50000, 10000, 5000, 1000, 500, 100};
		int[] charges = {    1,     1,    1,    1,   5,  10};
		
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
						System.out.print("충전 매수 : ");
						int add = scan.nextInt();
						
						tickets += add;
						System.out.println("충전 완료\n잔량 : " + tickets);
					}
					else if(choice == 2) {
						System.out.println("잔돈");
						for (int i = 0; i < charges.length; i++) {
							System.out.println(money[i] + " : " + charges[i]);
						}
						System.out.println();
						System.out.println("[0]5만 [1]1만 [2]5천 [3]1천 [4]5백 [5]1백");
						System.out.print("충전 지폐 : ");
						int p = scan.nextInt();
						
						System.out.print("충전 매수 : ");
						int cnt = scan.nextInt();
						
						
						charges[p] += cnt;
						System.out.println("충전 완료");
						
					}
					else if(choice == 3) {
						break;
					}
				}
				
			}
			else if(sel == 2) {
				while(true) {
					System.out.println("식권 잔량 : " + tickets);
					System.out.println("식권 가격 : " + price );
					
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");
					
					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if(choice == 1) {
						
						System.out.print("구매 매수 : ");
						int cnt = scan.nextInt();
						if(cnt > tickets) {
							System.out.println("식권이 부족합니다.");
							continue;
						}
						
						int total = price * cnt;
						
						System.out.println("가격 : " +total);
						int input[] = new int[6];
						int totalInput = 0;
						while(true) {
							
							
							System.out.println("[0]5만 [1]1만 [2]5천 [3]1천 [4]5백 [5]1백 [6]완료");
							System.out.println("현금 투입 : ");
							int ch = scan.nextInt();
							
							if(ch == 6) {
								System.out.println("");
								break;
							}
							input[ch] += 1;
							
							for (int i = 0; i < input.length; i++) {
								totalInput += input[i] * money[i];
							}
							System.out.println("투입 금액 : " + totalInput);
						}	
						int change = totalInput - total;
						
						if(total > totalInput) {
							System.out.println("금액이 부족합니다.");
						}else {
							
							int check[] = charges;
							
							int checkChange  = change;
							for (int i = 0; i < check.length; i++) {
								int run1 = 1;
								while(run1 == 1) {
									if(checkChange >= money[i] && check[i] > 0) {
										checkChange -= money[i];
										check[i] -= 1;
									}
									else {
										run1 = 0;
										break;
									}
								}
							}
							
							if(checkChange == 0) {
								for (int i = 0; i < check.length; i++) {
									charges[i] = check[i];
									charges[i] += input[i];
								}
								tickets -= cnt;
								
								System.out.println("투입 금액 : " + totalInput);
								System.out.println("결제 금액 : " + total);
								System.out.println("거스름돈 : " + change);
								
							}else {
								System.out.println("잔돈 부족");
				
							}
				
						}
					}
					else if(choice == 2) {
						break;
					}
				}		
			}
		}
	}

}
