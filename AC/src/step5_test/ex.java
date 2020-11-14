package step5_test;

import java.util.Random;

public class ex {
	public static void main(String[] args) {
		
		Random rn = new Random();
		
		int size = 10;
		
		int p1 = 0;
		int p2 = 0;
		
		int cnt = 0;
		int rank[] = new int[2];
		
		boolean on = false; // on/off 스위치 기능의 변수를 boolean 으로 구현할 수 있다 
		while(true) {
			on = false;	// while문에 진입할 때마다 1개만 기록가능
			
			// 게임종료
			int check = 0;
			for(int i=0; i<rank.length; i++) {
				if(rank[i] != 0) {
					check ++;
				}
			}
			if(check == 2) {
				break;
			} 
			
			// 달리기
			int move = rn.nextInt(3) +1;
			p1 += move;
			
			if(p1 > size) {
				if(on != true) {
					rank[cnt] = 1;
					System.out.println("p1 도착!");
				}
			} 
			
			move = rn.nextInt(3) +1;
			p2 += move;
			if(p2 > size) {
				if(on != true) {
					rank[cnt] = 1;
					System.out.println("p2 도착!");
				} else {
					continue;
				}
			} 
			
			
		}

	}

}
