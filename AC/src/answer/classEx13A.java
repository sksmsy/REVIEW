package answer;

import java.util.Random;
import java.util.Scanner;

class Ex13{
	int game[] = new int[6];
	int idx[] = new int[3];
	int myIdx[] = new int[3];
	int total = 0;
}
public class classEx13A {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		Ex13 e = new Ex13();
		
		for(int i=0; i<e.game.length; i++) {
			int r = ran.nextInt(10) + 1;
			
			int check = 1;
			for(int j=0; j<i; j++) {
				if(e.game[j] == r) {
					check = -1;
				}
			}
			
			if(check == 1) {
				e.game[i] = r;
			}else {
				i -= 1;
			}
		}
		
		System.out.println("\t[더하기 게임]");
		
		System.out.print("숫자카드 >>> ");
		for(int i=0; i<e.game.length; i++) {
			System.out.print(e.game[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i<e.idx.length; i++) {
			int r = ran.nextInt(e.game.length);
			
			int check = 1;
			for(int j=0; j<i; j++) {
				if(e.idx[j] == r) {
					check = -1;
				}
			}
			
			if(check == 1) {
				e.idx[i] = r;
				e.total += e.game[r];
			}else {
				i -= 1;
			}
		}
		System.out.print("치트키    >>> ");
		for(int i=0; i<e.idx.length; i++) {
			System.out.print(e.idx[i] + " ");
		}
		System.out.println();
		
		System.out.println("합 = " + e.total);
		
		while(true) {
			
			int total = 0;
			for(int i=0; i<e.myIdx.length; i++) {
				System.out.print((i+1) + ".인덱스 입력 : ");
				int idx = scan.nextInt();
				
				int check = 1;
				for(int j=0; j<i; j++) {
					if(e.myIdx[j] == idx) {
						check = -1;
					}
				}
				
				if(check == 1) {
					e.myIdx[i] = idx;
					total += e.game[idx];
				}else {
					i -= 1;
				}
			}
			
			if(e.total == total) {
				System.out.println("정답!");
				break;
			}else {
				System.out.println("땡!");
			}
			
		}

	}

}
