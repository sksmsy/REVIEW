package allRe;

import java.util.Random;
import java.util.Scanner;

public class ArrayEx30 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		final int SIZE = 9;
		
		int f[] = new int[SIZE];
		int b[] = new int[SIZE];
		
		for (int i = 0; i < b.length; i++) {
			f[i] = i+1;
			b[i] = SIZE + (i+1);
		}
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(SIZE);
			
			int temp = f[0];
			f[0] = f[r];
			f[r] = temp;
			
			r = ran.nextInt(SIZE);
			
			temp = b[0];
			b[0] = b[r];
			b[r] = temp;
			
		}
		int num = 1;
		while(true) {
			
			System.out.println("["+ num + "]");
			for (int i = 0; i < b.length; i++) {
				System.out.print(f[i] + "   ");
				
				if(i % 3 == 2) {
					System.out.println();
				}
			}
			
			System.out.print("입력 : ");
			int myNum = scan.nextInt();
			
			if(num == f[myNum]) {
				if(num > 0 && num <=9) {
					f[myNum] = b[myNum];
				}else {
					f[myNum] = 0;
				}
				num+= 1;
			}
			
			
			if(num == 19) {
				break;
			}
			
		}
		
	}

}
