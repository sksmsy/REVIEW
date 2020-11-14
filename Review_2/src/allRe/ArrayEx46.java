package allRe;

import java.util.Random;

public class ArrayEx46 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		int set [][] = new int[5][7];
		
		int win = 0;
		
		
		for (int i = 0; i < set.length; i++) {	
			for (int j = 0; j < set[i].length; j++) {
				int r = ran.nextInt(2);
				if(r == 0) {
					set[i][j] = 0;
				}else {
					set[i][j] = 3;
				}
			}
			
			int check = -1;
			int cnt = 0;
			
			for (int j = 0; j < set[i].length; j++) {
				if(set[i][j] == 3) {
					cnt += 1;
				}else {
					cnt = 0;
				}
				
				
				if(cnt == 3) {
					check = 1;
				}
			}
			
			
			if(check == 1 && win == 0) {
				win = 1;
			}else if(check == 1 && win == 1) {
				i -= 1;
			}else if(check == -1 && win == 0) {
				i -= 1;
			}
		}

		
		for (int i = 0; i < set.length; i++) {
			for (int j = 0; j < set[i].length; j++) {
				System.out.print(set[i][j] + " ");
				
			}
			System.out.println();
		}
		
		
		
	
		
	}

}
