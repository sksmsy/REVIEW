package step6_test;

import java.util.Scanner;

/*
 * # 숫자 이동하기 : 클래스 + 메서드
 * 1. 숫자 8은 캐릭터이다.
 * 2. 숫자 1을 입력하면, 캐릭터가 왼쪽으로 이동한다.
 * 3. 숫자 2를 입력하면, 캐릭터가 오른쪽으로이동한다.
 * 4. 좌우 끝에 도달했을 때 에러가 발생하지 않도록 예외처리를 해준다.
 */


class NumGame{
	
	Scanner sc = new Scanner(System.in);
	int mv[] = {0,0,0,0,8,0,0,0,0,0};
	int player = 4;
	
	void printPlay() {
		for (int i = 0; i < mv.length; i++) {
			if(mv[i] == 0) {
				System.out.print("[ ]");
			}else {
				System.out.print("옷");
			}
		}
		System.out.println();
	}
	
	void showMenu() {
		System.out.println("1.left");
		System.out.println("2.right");
		System.out.println("3.close");
	}
	
	void mvLeft() {
		if(player > 0){
			mv[player] = 0;
			mv[player-1] = 4;
			player -= 1;
		}
		else {
			System.out.println("더이상 움직일수 없습니다.");
		}
	}
	void mvRight() {
		if(player < mv.length-1) {
			mv[player]=0;
			mv[player+1] = 4;
			player += 1;
		}
		else {
			System.out.println("더이상 움직일수 없습니다.");
		}
	}
	void run() {
		
		while(true) {
			printPlay();
			showMenu();
			int mv = sc.nextInt();
			
			
			if(mv == 1) {
				mvLeft();
			}else if(mv == 2) {
				mvRight();
			}else if(mv ==3) {
				break;
			}
		}
	}
	
}



public class test4 {
	public static void main(String[] args) {
		NumGame ng = new NumGame();
		
		ng.run();
	}
}
