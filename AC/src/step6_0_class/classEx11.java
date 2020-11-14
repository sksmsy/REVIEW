package step6_0_class;

import java.util.Random;
import java.util.Scanner;

class Ex11{
	final int SIZE = 9;
	int front[] = new int[SIZE];
	int back[] = new int[SIZE];
}

public class classEx11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		Ex11 e = new Ex11();
		
		
		for (int i = 0; i < e.front.length; i++) {
			e.front[i] = i+1;
			e.back[i] = e.SIZE + (i+1);
		}

		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(e.SIZE);
			
			int temp = e.front[0];
			e.front[0] = e.front[r];
			e.front[r] = temp;
		
			r = ran.nextInt(e.SIZE);
			
			temp = e.back[0];
			e.back[0] = e.back[r];
			e.back[r] = temp;
		
		}
		
		

		int cnt = 1;
		while(cnt < 19) {
			System.out.println("["+cnt+"]");
			for (int i = 0; i < e.front.length; i++) {
				System.out.print(e.front[i] +"\t");
				
				if(i % 3 == 2) {
					System.out.println("\n");
				}
			}
			
			
			System.out.print("입력 : ");
			int idx = sc.nextInt();
					
			if(e.front[idx-1] == cnt) {
				
				if(cnt < 10) {
					e.front[idx-1] = e.back[idx-1];
				}else {
					e.front[idx-1] =0;
				}
				cnt++;
			}
			
		}
		
		
	}

}
