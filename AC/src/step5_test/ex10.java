package step5_test;

import java.util.Random;
import java.util.Scanner;

public class ex10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 10;
		
		int map[][]=new int[SIZE][SIZE];
		
		int leng = 4;
		int sn[][] = new int[leng][2];

		int item = 4;
		
		for (int i = 0; i < sn.length; i++) {
			sn[i][1] = i+4;
		}
		
		
		boolean run = true;
		
		while(run) {
			
			
			for (int i = 0; i < sn.length; i++) {
				map[sn[i][0]][sn[i][1]] = 1;
			}
			
			
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if(map[i][j] == 1) {
						System.out.print("■ ");
					}else if(map[i][j] == 2) {
						System.out.print("● ");
					}else {
						System.out.print("+ ");
					}
				}
				System.out.println();
			}
			
			
			System.out.print("입력 : ");
			int mv = scan.nextInt();
			
			
			if(mv == 4 || mv == 5 ||  mv == 6 || mv == 8) {
				
				int yy = sn[0][0];
				int xx = sn[0][1];
				
				if(mv == 8) yy--;
				else if(mv == 5) yy++;
				else if(mv == 4) xx--;
				else if(mv == 6) xx++;
				
				if(yy >= SIZE || yy < 0) continue;
				if(xx >= SIZE || xx < 0) continue;
				
				if(map[yy][xx] == 1) {
					System.out.println("die");
					run = false;
				}
				
				
				if(map[yy][xx] == 2) {
					int temp[][] = sn;
					sn = new int[leng+1][2];
					
					for (int i = 0; i < temp.length; i++) {
						sn[i] = temp[i];
					}
					temp = null;
					
					leng ++;
				}

				map[sn[leng-1][0]][sn[leng-1][1]] = 0;

				for (int i = leng-1; i > 0 ; i--) {
					sn[i][0] = sn[i-1][0];
					sn[i][1] = sn[i-1][1];
				}

				sn[0][0] = yy;
				sn[0][1] = xx;
					
			}
			
			int r = ran.nextInt(2);
			if(r > 0) {
				while(item > 0) {
					int rY = ran.nextInt(SIZE);
					int rX = ran.nextInt(SIZE);
					
					if(map[rY][rX] == 0) {
						map[rY][rX] = 2;
						item --;
						break;
					}
				}				
			}

			
		}
		

	}

}

//1525
//1600