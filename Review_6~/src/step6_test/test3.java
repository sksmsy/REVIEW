package step6_test;

import java.util.Scanner;

class Ex3{
	Scanner sc = new Scanner(System.in);
	
	int seat[] = new int[8];
	
	int cnt = 0;
	int money = 0;
	
	
	void show_menu() {
		
		System.out.println("=========");
		System.out.println("[1]예매");
		System.out.println("[2]종료");
		System.out.print(">>>");
	}
	
	void show_seat() {
		
		for (int i = 0; i < seat.length; i++) {
			if(seat[i] == 0) {
				System.out.print("O ");
			}else if(seat[i] == 1){
				System.out.print("X ");
			}
		}
		System.out.println();
	}
	
	void choice() {
		show_seat();
		
		System.out.println("choice [1~8]");
		int num = sc.nextInt()-1;
		if(seat[num] == 0) {
			
			seat[num] = 1;
			cnt ++;
		}else {
			System.out.println("이미 예매된 좌석입니다.");
		}
	}
	
	void money() {
		money = cnt * 12000;
		
		System.out.println(money);
	}
	
	void run() {
		while(true) {
			show_menu();
			int sel = sc.nextInt();
			
			if(sel == 1) {
				choice();
			}else if(sel == 2) {
				money();
			}
			
		}
	}
	
}

public class test3 {
	public static void main(String[] args) {
		Ex3 e3 = new Ex3();
		
		e3.run();
	}
}
