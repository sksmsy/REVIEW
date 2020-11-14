package step5_test;

import java.util.Random;

public class ex7 {
	
	static void printRace(int arr[][]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 20; j++) {
				if(arr[i][j] == 1) {
					System.out.print("[H]");
				}else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
		System.out.println("====================================");
	}
	

	public static void main(String[] args) {
		Random ran = new Random();

		
		int race[][] = new int[5][20];
		int max = 20;
		int rank[] = new int[5];
		
		
		// ex) size = 10
		// 1 2 3 4 5 ... : 횟수
		// 3 3 4 도착 -> rank배열에 기록 (말의 인덱스)
		// 6 2 [2] 도착 -> rank배열에 기록 

		for (int i = 0; i < 5; i++) {
			race[i][0] = 1;
			
		}
		
		
		int cnt = 0;
		int x = 0;
		
		boolean record;
		while(true) {
			record = false;
				
			int check = 0;
			for (int i = 0; i < rank.length; i++) {
				if(rank[i] > 0) {
					check ++;
				}
			}
			if(check == 5) {
				
				for (int i = 0; i < rank.length; i++) {
					System.out.println("["+(i+1)+"]"+rank[i]+"등");
				}
				break;
			}
			
			for (int i = 0; i < 5; i++) {
				int r = ran.nextInt(3)+1;
				if(race[i][x] == 1) {
					
					if(x+r >= 19) {
						//
						System.out.println("x+r : " + (x+r));
						if(record == false) {							
							race[i][19] = 1;
							race[i][x] = 0;
							rank[i] = ++cnt; // ++a, a++
							record=true;
							printRace(race);
						}else {
							record = false;
							i--;
						}
					}
					else if(x+r <= 19) {
						race[i][x+r] = 1;
						race[i][x] = 0;
						printRace(race);
					}
				}
			}
			x++;
			
			
			
			
			// 도착한 말이 기록되는 순간 ->
			// if(record == false) { 기록 record = true }
			// else if(record == true){ 동시도착 -> r값 다시 랜덤 }
			// 
			
			
			
		
		}
		
		
	}

}


