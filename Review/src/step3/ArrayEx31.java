package step3;

import java.util.Random;
import java.util.Scanner;

/*
 * # 1 to 18
 */
public class ArrayEx31 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 9;
		
		int front[] = new int[SIZE];
		int back[] = new int[SIZE];
		
		for (int i = 0; i < front.length; i++) {
			front[i] = i + 1;
			back[i] = SIZE + (i + 1);
		}
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(9);
			
			int temp = front[0];
			front[0] = front[r];
			front[r] = temp;
			
			
			temp = back[0];
			back[0] = back[r];
			back[r] = temp;
		}
		
		int num = 1;
		while(true) {
			
			System.out.println("["+num+ "]");
			
			for (int i = 0; i < front.length; i++) {
				System.out.print(front[i] + "   ");
				if(i % 3 == 2) {
					System.out.println();
				}
			}
			
			
			System.out.print("입력 : ");
			int myNum = scan.nextInt();
			
			if(front[myNum] == num) {
				if(num <= 9 ) {
					front[myNum] = back[myNum];
					
				}else {
					front[myNum] = 0;
				}
				
				num += 1;
				
			}
			
			if(num == 19) {
				break;
			}
			
		}
		
		
		
	}

}
