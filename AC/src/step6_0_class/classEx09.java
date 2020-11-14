package step6_0_class;

import java.util.Random;
import java.util.Scanner;

class Ex09{
	int front[]  = {1,1,2,2,3,3,4,4,5,5};
	int back []  = new int[10];
	
	int cnt = 0;
}

public class classEx09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		Ex09 e = new Ex09();
		
		
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(10);
			
			int temp = e.front[0];
			e.front[0] = e.front[r];
			e.front[r] = temp;
			
		}
		
		while(true) {
			
			for (int i = 0; i < e.front.length; i++) {
				System.out.print(e.front[i] + " ");
			}
			System.out.println();
			
			for (int i = 0; i < e.back.length; i++) {
				System.out.print(e.back[i] + " ");
			}
			System.out.println();
			
			
			if(e.cnt == 5) {
				break;
			}
			
			System.out.print("idx1 : ");
			int idx1 = sc.nextInt();
			
			System.out.print("idx2 : ");
			int idx2 = sc.nextInt();
			
			if(-1 < idx1 && idx1 < 10 && -1<idx2 && idx2 < 10) {
				
				if(e.front[idx1] == e.front[idx2]) {
					e.back[idx1] = e.front[idx1];
					e.back[idx2] = e.front[idx2];
					e.cnt += 1;
				}
			}
			
		}
		
		
	}

}
