package allRe;

import java.util.Scanner;

public class ArrayEx26 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int game [] = {0, 0, 1, 0 ,2, 0 ,0, 1, 0};
		
		
		while(true) {
			
			int player = 0;
			for (int i = 0; i < game.length; i++) {
				if(game[i] == 2) {
					System.out.print("옷 ");
					player = i;
				}else if(game[i] == 1) {
					System.out.print("벽 ");
				}else {
					System.out.print(game[i] + " ");
				}
			}
			System.out.println();
			
			System.out.print("입력 : ");
			int mv = scan.nextInt();
			
			if(mv == 1 && player -1 >= 0) {
				if(game[player-1] == 1) {
					System.out.print("벽 부수기 3 : ");
					int wall = scan.nextInt();
					if(wall != 3) {
						continue;
					}
				}
				game[player] = 0;
				game[player-1] = 2;
				
			}else if(mv == 2 && player+1 < 9) {
				if(game[player+1] == 1) {
					System.out.print("벽 부수기 3 : ");
					int wall = scan.nextInt();
					if(wall != 3) {
						continue;
					}
				}
				game[player] = 0;
				game[player+1] = 2;
				
			}
			
		}
		
	}

}
