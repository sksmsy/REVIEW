package step4_test;

import java.util.Scanner;

public class test05 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int size =5; 
		int road = 20;
		
		int[][] map = {
			{0,   1,  2,  3, 4},	
			{15, 20, 20, 20, 5},
			{14, 20, 20, 20, 6},
			{13, 20, 20, 20, 7},
			{12, 11, 10,  9, 8}
		};
		
		int player = 0;
		
		while(true) {

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j]==road) {
						System.out.print("■ ");
					}else if(map[i][j] == player) {
						System.out.print("옷 ");
					}else { 
						System.out.print("□ ");
					}
				}
				System.out.println();
			}
			System.out.println();
			
			System.out.println("1~3입력 : ");
			int mv = scan.nextInt();
			
			player += mv;
			
			player %= 16;
			
		}
		
		
	}

}
