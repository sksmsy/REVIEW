package allRe;

import java.util.Scanner;

public class ArrayEx27 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int exit = 10;
		
		int game[] = {11,15,10,14,12,13};
		
		while(true) {
			
			for (int i = 0; i < game.length; i++) {
				System.out.print(game[i] + " ");
			}System.out.println();
			
			System.out.print("입력 : " );
			int num = scan.nextInt();
			
			if(exit == game[num]) {
				game[num] = 0;
				exit += 1;
			}
			if(exit == 16) {
				break;
			}
		}
	}

}
