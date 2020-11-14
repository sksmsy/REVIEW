package step6;

import java.util.Scanner;

class Ex7{
	int arr [] = new int [8];
	
	int cnt = 0;
	int money = 0;
}

public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Ex7 e = new Ex7();
		
		while (true) {
			System.out.println("========");
			System.out.println("[1]예매");
			System.out.println("[2]종료");
			System.out.print(">>>");
			int sel =sc.nextInt();
			
			if(sel == 1) {
				
				for (int i = 0; i < e.arr.length; i++) {
					if(e.arr[i] == 0) {
						System.out.print("O ");
					}
					else if(e.arr[i] == 1) {
						System.out.print("X ");
					}
				}
				System.out.println();
				
				System.out.println("[1~8]");
				int num = sc.nextInt()-1;
				
				if(e.arr[num] == 0) {
					e.arr[num] = 1;
					System.out.println("예매완");
					e.cnt ++;
				}else {
					System.out.println("이미 예매가 완료된 자리입니다.");
				}
				
			}
			else if(sel == 2) {
				e.money = e.cnt * 12000;
				System.out.println(e.money);
				break;
			}
		}
		
	}
}
