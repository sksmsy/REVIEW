package step5_test;

import java.util.Scanner;

public class Ex_Test1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int game[][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,0}
				};
		
		int yx [][] = new int[100][2];
	
		int size = 4;
		int pY = 0;
		int pX = 0;
		int cnt = 0 ;
		
		
		while(true) {
			
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[i].length; j++) {
					if(game[i][j] == 0) {
						pY = i; pX = j;
					}
					System.out.print(game[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println("1)left 2)right 3)up 4)down");
			System.out.println("5)return");
			int sel = scan.nextInt();
			
			if(sel == 1 || sel == 2 || sel == 3 || sel == 4) {
				
				int mY = pY;
				int mX = pX;
				
				if(sel == 1) mX --;
				else if(sel == 2) mX ++;
				else if(sel == 3) mY --;
				else if(sel == 4) mY ++;
				
				if(mY < 0 || size <= mY)continue;
				if(mX < 0 || size <= mX)continue;
				
				int temp = game[pY][pX];
				game[pY][pX] = game[mY][mX];
				game[mY][mX] = temp;
				
				yx[cnt][0] = pY;
				yx[cnt][1] = pX;
				cnt ++;
			}
			
			else if( sel == 5) {
				if(cnt > 0) {
					cnt--;
					
					int rY = yx[cnt][0]; 
					int rX = yx[cnt][1];
					
					int temp = game[pY][pX];
					game[pY][pX] = game[rY][rX];
					game[rY][rX] = temp;
					
				}
			}	
		}

	
	}

}
