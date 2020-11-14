package step6_0_class;

import java.util.Random;
import java.util.Scanner;

class Ex13{
	int game[] = new int[6];
	int idx[] = new int[3];
	int myIdx[] = new int[3];
	int tot = 0;
}

public class classEx13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Ex13 e = new Ex13();
		
		for (int i = 0; i < e.game.length; i++) {
			int r = ran.nextInt(10)+1;
			e.game[i] = r;
			for (int j = 0; j < i; j++) {
				if(e.game[i] == e.game[j]) {
					i--;
				}
			}
		}
		System.out.print("숫자 : ");
		for (int i = 0; i < e.game.length; i++) {
			System.out.print(e.game[i] + " ");
		}System.out.println();
		
		for (int i = 0; i < e.idx.length; i++) {
			int r = ran.nextInt(5);
			e.idx[i] = r;
			for (int j = 0; j < i; j++) {
				if(e.idx[i] == e.idx[j]) {
					i--;
				}
			}
		}		
		for (int i = 0; i < e.idx.length; i++) {
			e.tot += e.game[e.idx[i]];
		}
		System.out.print(">> ");
		for (int i = 0; i < e.idx.length; i++) {
			System.out.print(e.idx[i] + " ");
		}
		System.out.println();
		System.out.println("합 : " + e.tot);
		
		while(true) {
			for (int i = 0; i < e.idx.length; i++) {
				System.out.print((i+1)+".idx : ");
				e.myIdx[i] = sc.nextInt();
			}
			
			int check = 0;
			for (int i = 0; i < e.idx.length; i++) {
				for (int j = 0; j < e.idx.length; j++) {
					if(e.idx[i] == e.myIdx[j]) {
						check ++;
					}
				}
			}
			
			if(check == 3) {
				System.out.println("정답");
				break;
			}else {
				System.out.println("땡");
			}
			
			
		}
			
	}

}
