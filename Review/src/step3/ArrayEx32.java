package step3;

import java.util.Scanner;

public class ArrayEx32 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int MAX = 5;

		int[] arId = new int[MAX];
		int[] arPw = new int[MAX];
		int[] arMo = new int[MAX];

		int cnt = 0;
		int log = -1;

		String menu = "=== ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";

		while (true) {
			for (int i = 0; i < arId.length; i++) {
				System.out.print(arId[i] + " ");

			}
			System.out.println();

			System.out.println(menu);

			int sel = scan.nextInt();

			if (sel == 1) {
				if (cnt == 5) {
					System.out.println("더이상 회원가입이 불가능합니다.");
				}

				if (log > -1) {
					System.out.println("이미 로그인 되어 있습니다.");
					continue;
				}

				System.out.print("ID : ");
				int myId = scan.nextInt();

				int check = 0;
				for (int i = 0; i < MAX; i++) {
					if (myId == arId[i]) {
						check = -1;
					}
				}

				if (check == -1) {
					System.out.println("ID 중복");
				} else {
					System.out.print("PW : ");
					int myPw = scan.nextInt();

					arId[cnt] = myId;
					arPw[cnt] = myPw;

					cnt += 1;
				}

			} else if (sel == 2) {
				if (log == -1) {
					System.out.println("로그인이 필요합니다.");
					continue;
				}

				System.out.print("탈퇴하시겠습니까? ([1]예 / [2]아니오)");
				int del = scan.nextInt();

				if (del == 1) {
					arId[log] = 0;
					arPw[log] = 0;
					arMo[log] = 0;

					log = -1;
					cnt -= 1;
					System.out.println("탈퇴 완료");
				}

			} else if (sel == 3) {
				if (log == -1) {
					System.out.print("ID : ");
					int myId = scan.nextInt();

					System.out.print("PW : ");
					int myPw = scan.nextInt();

					int check = -1;
					for (int i = 0; i < MAX; i++) {
						if (myId == arId[i] && arPw[i] == myPw) {
							check = i;

						}
					}

					if (check == -1) {
						System.out.println("ID또는PW를 확인해주세요.");
					} else if (check > -1) {
						System.out.println(arId[check] + "님 환영합니다.");
						log = check;
					}
				}else {
					System.out.println("이미 로그인중 입니다.");
				}
			}

			else if (sel == 4) {
				if(log == -1) {
					System.out.println("로그인이 필요합니다.");
				}else {
					System.out.print("로그아웃 되었습니다.");
					log = -1;
				}
				
			} else if (sel == 5) {
				if(log == -1) {
					System.out.println("로그인이 필요합니다.");
				}else {
					System.out.println("입금금액 : ");
					int myMoney = scan.nextInt();
					
					arMo[log] = myMoney;
					
					System.out.println("입금완료");
					
				}
				
			} else if (sel == 6) {
				if(log == -1) {
					System.out.println("로그인이 필요합니다.");
				}else {
					System.out.print("입금계좌 : ");
					int reAcc = scan.nextInt();
					
					
					int check = -1;
					for (int i = 0; i < MAX; i++) {
						if(reAcc == arId[i]) {
							check = i;
						}
					}
					
					if(check == - 1) {
						System.out.println("이체 계좌를 확인해주세요");
					}else {
						System.out.print("PW : ");
						int myPw = scan.nextInt();
						
					
						if(myPw != arPw[log]) {
							System.out.println("PW를 확인해주세요");
						}else { 
							System.out.print("이체금액 : ");
							int money = scan.nextInt();
							
							if(arMo[log] < money) {
								System.out.println("잔액이 부족합니다.");
							}else {
								arMo[log] -= money;
								arMo[check] += money;
								System.out.println("이체완료");
							}
						}
					}
				}				
				
			} else if (sel == 7) {
				if(log == -1) {
					System.out.println("로그인이 필요합니다.");
				}else {
					System.out.println(arMo[log]+"원");
				}
				
			} else if (sel == 0) {
				break;
			}
		}

	}

}
