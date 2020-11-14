package step4_19;

import java.util.Random;

//# 경마 게임
//5마리의 말이 랜덤으로 한번에 일정거리 이동가능하다 
//이동한거리의 합이 20이상이면 도착 
//등수 출력 
//조건) 단! 동시도착 예외처리

public class Ex06_HR {

	public static void main(String[] args) {
		Random ran = new Random();
		
		

		int rank[]  = new int[5];
		
		int cnt = 1;
		
		int run[][] = new int[5][20];
		
		for (int i = 0; i < run.length; i++) {
			run[i][0] = 1;
		}
		
		int x = 0;
		int y = 0;
		
		while(true) {
			
			int check = 0;
			for (int i = 0; i < rank.length; i++) {
				if(rank[i] != 0) {
					check++;	
				}
			}
			
			if(check == 5) {
				
				for (int i = 0; i < run.length; i++) {
					System.out.println("["+(i+1)+"]"+rank[i]+"등");
				}
				break;
			}
			
			for (int i = 0; i <5; i++) {		
				for (int j = 0; j < 20; j++) {
					if(run[i][j] == 1) {
						System.out.print("[H]");
					}else {
						System.out.print("[ ]");
					}
				}
				System.out.println();
			}
			System.out.println("==========================");
			
			
			
			for (int i = 0; i < 5; i++) {
				int r = ran.nextInt(3)+1;
				
				if(run[i][x] == 1) {
	
					if(x+r <= 19) {
						run[i][x+r] = 1;														
					}else if(x+r >= 19) {
						
						rank[i] = cnt++;
					}
					run[i][x] = 0;
				}
			}
			x++;
			
			
		
			

			
			
		}
		
		
	}
}
