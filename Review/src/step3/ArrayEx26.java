package step3;

import java.util.Scanner;

/*
 * # 숫자이동
 */
public class ArrayEx26 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int game[] = { 0, 0, 1, 0, 2, 0, 0, 1, 0};
		
		int player = 0;
		for (int i = 0; i < game.length; i++) {
			if(game[i] == 2) {
				player = i;
			}
		}
		
		
		while(true) {
			
			for (int i = 0; i < game.length; i++) {
				if(game[i] == 2) {
					System.out.print("옷 ");
				}else {
					System.out.print(game[i] + " ");
				}
			}System.out.println();
			
			
			System.out.print("이동 : ");
			int mv = scan.nextInt();
			
	
			if(mv == 1) {
				if(player - 1 > 0) {
					if(game[player - 1] == 1) {
						System.out.print("벽 부수기(3) : ");
						int wall = scan.nextInt();
						if(wall != 3) {
							continue;
						}
					}
					game[player - 1] = 2;
					game[player] = 0;
					player -= 1;
				}
				
			}else if(mv == 2) {
				if(player +1 < 9) {
					if(game[player + 1] == 1) {
						System.out.print("벽 부수기(3) : ");
						int wall = scan.nextInt();
						if(wall != 3) {
							continue;
						}
					}
					game[player + 1] = 2;
					game[player] = 0;
					player += 1;
				}
			}
			
			
		}
		
		
	}

}
