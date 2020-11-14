package allRe;

import java.util.Random;
import java.util.Scanner;

public class mini16_yh {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int max = 5;
		
		int me [][] = new int [max][max];
		int you [][] = new int [max][max];
		
		int temp[] = new int[max*max];
		
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = ran.nextInt(50)+1;
			for (int j = 0; j < i; j++) {
				if(temp[i]==temp[j]) {
					i--;
				}
			}
		}
		
		int k = 0;
		for (int i = 0; i < max; i++) {
			for (int j = 0; j <max; j++) {
				me[i][j] = temp[k];
				k++;
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = ran.nextInt(50)+1;
			for (int j = 0; j < i; j++) {
				if(temp[i]==temp[j]) {
					i--;
				}
			}
		}
		
		k = 0;
		for (int i = 0; i < max; i++) {
			for (int j = 0; j <max; j++) {
				you[i][j] = temp[k];
				k++;
			}
		}
		
		int win = 0;
		int turn = 0;
		
		while(true) {
			System.out.println("===============[p1]================");
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < max; j++) {
					if(me[i][j] == 0) {
						System.out.print("X\t");
					}else {
						System.out.print(me[i][j] + "\t");
					}
				}
				System.out.println("\n");
			}
			System.out.println();
			
			System.out.println("===============[p2]================");
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < max; j++) {
					if(you[i][j] == 0) {
						System.out.print("X\t");
					}else {
						System.out.print(you[i][j] + "\t");
					}
				}
				System.out.println("\n");
			}
			System.out.println();
			
			if(win == 1) {
				System.out.println("[p1]WIN");
				break;
			}
			if(win == 2) {
				System.out.println("[p2]WIN");
				break;
			}
			
			if(turn % 2 == 0) {
				System.out.print("[p1]입력 : ");
				int myNum = scan.nextInt();
				
				for (int i = 0; i < me.length; i++) {
					for (int j = 0; j < me[i].length; j++) {
						if(myNum == me[i][j]) {
							me[i][j] = 0 ;
						}
					}
				}
				
				for (int q = 0; q < me.length; q++) {
					for (int w = 0; w < me[q].length; w++) {
						if(myNum == you[q][w]) {
							you[q][w] = 0 ;
						}
					}
				}
				turn += 1;
			}
			
			else if(turn % 2 == 1) {
				System.out.print("[p2]입력 : ");
				int myNum = scan.nextInt();
				
				for (int i = 0; i < me.length; i++) {
					for (int j = 0; j < me[i].length; j++) {
						if(myNum == you[i][j]) {
							you[i][j] = 0 ;
						}
					}
				}
				
				for (int i = 0; i < me.length; i++) {
					for (int j = 0; j < me[i].length; j++) {
						if(myNum == me[i][j]) {
							me[i][j] = 0 ;
						}
					}
				}
				turn += 1;
			}
			
		
			
			
			//----------------검사--------------------
			
			
			for (int i = 0; i < me.length; i++) {
				int cnt = 0;
				for (int j = 0; j < me[i].length; j++) {
					if(me[i][j] == 0) {
						cnt += 1;
					}
				}
				if(cnt == 5) {
					win = 1;
					break;
				}
			}
			for (int i = 0; i < me.length; i++) {
				int cnt = 0;
				for (int j = 0; j < me[i].length; j++) {
					if(you[i][j] == 0) {
						cnt += 1;
					}
				}
				if(cnt == 5) {
					win = 2;
					break;
				}
			}
			
			for (int i = 0; i < me.length; i++) {
				int cnt = 0;
				for (int j = 0; j < me[i].length; j++) {
					if(me[j][i] == 0) {
						cnt+=1;
					}
				}
				
				if(cnt==5) {
					win = 1;
					break;
				}
			}
			for (int i = 0; i < me.length; i++) {
				int cnt = 0;
				for (int j = 0; j < me[i].length; j++) {
					if(you[j][i] == 0) {
						cnt+=1;
					}
				}
				
				if(cnt==5) {
					win = 2;
					break;
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < max; i++) {
				if(me[i][i] == 0) {
					cnt++;
				}
				if(cnt == 5) {
					win = 1;
					break;
				}
			}
			cnt = 0;
			for (int i = 0; i < max; i++) {
				if(you[i][i] == 0) {
					cnt++;
				}
				if(cnt == 5) {
					win = 2;
					break;
				}
			}
			
			
			cnt = 0;
			for (int i = 0; i < max; i++) {
				if(me[i][(max-1)-i] == 0) {
					cnt ++;
				}
				if(cnt ==5) {
					win = 1;
					break;
				}
				
			}
			cnt = 0;
			for (int i = 0; i < max; i++) {
				if(you[i][(max-1)-i] == 0) {
					cnt ++;
				}
				if(cnt ==5) {
					win = 2;
					break;
				}
				
			}
			
			
		}
	}

}
