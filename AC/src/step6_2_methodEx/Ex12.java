package step6_2_methodEx;

import java.util.Scanner;

class Reservation{
	Scanner sc = new Scanner(System.in);
	
	int arr[] = new int [10];
	
	int cnt = 0;
	int price = 0;
	
	void menu() {
		System.out.println("==============");
		System.out.println("1.예매");
		System.out.println("2.종료");
	}
	
	void seat() {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				System.out.print("[0]");
			}else {
				System.out.print("[X]");
			}
		}System.out.println();
	}
	void choiceSeat() {
		
		seat();
		
		System.out.println("예매할 좌석(1~10) : ");
		int choice = sc.nextInt();
		
		if(arr[choice-1] == 0) {
			System.out.println("예매완료");
			cnt++;
		}else {
			System.out.println("이미 예매된 좌석입니다.");
		}
	}
	
	void close() {
		
		price = cnt * 12000;
		System.out.println(price);
	}
	
	void run() {
		
		while(true) {
			
			menu();
			System.out.println("메뉴선택 : ");
			int sel = sc.nextInt();
			
			
			if(sel == 1) {
				choiceSeat();
			}else {
				close();
				break;
			}
			
		}
	}

}
public class Ex12 {

	public static void main(String[] args) {
		
		Reservation r = new Reservation();
		
		r.run();
	}

}
