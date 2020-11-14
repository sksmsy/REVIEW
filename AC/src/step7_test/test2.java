package step7_test;

import java.util.Random;
import java.util.Scanner;

class Reservation{
	boolean check;
	
	void showData() {
		if(check == true) {
			System.out.print("■ ");
		}else {
			System.out.print("□ ");
		}
	}
	
}
public class test2 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		Reservation [] arr = new Reservation[8];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Reservation();
		}
		
		while(true) {
		
			System.out.println("[1]예매");
			System.out.println("[2]종료");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				
				
				for (int i = 0; i < arr.length; i++) {
					arr[i].showData();
				}
				
				System.out.println();
				
				System.out.print("선택[1~8] >>");
				int choice = sc .nextInt()-1;
				
				if(arr[choice].check == false) {
					arr[choice].check = true;
					System.out.println("예매 완료");					
				}else {
					System.out.println("이미 예매된 자리");
				}
			}
			else {
				break;
			}
			
		}
	}
}
//1635
//1642