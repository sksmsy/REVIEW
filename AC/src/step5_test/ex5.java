package step5_test;

import java.util.Random;
import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int score = 100;
		String word = "performance";
		String mean = "공연";
		
		int size = word.length();
		int check[] = new int[size];
		
		while(true) {
			
			int c = 0;
			for (int i = 0; i < size; i++) {
				if(check[i] ==0) {
					c += 1;
					break;
				}
			}
			
			
			if( c== 0) {
				break;
			}
			
			System.out.println("mean : " + mean);
			System.out.print("Q : ");
			for (int i = 0; i < size; i++) {
				if(check[i] == 1) {
					System.out.print(word.charAt(i));
				}
				
				else {
					System.out.print("*");
				}
				
			}
			System.out.println();
			System.out.print(" >>> ");
			String me = scan.next();
			
			if(me.equals(word) == false) {
				while(true) {
					int r = ran.nextInt(size);
					if(check[r] == 0) {
						check [r] = 1;
						for (int i = 0; i < size; i++) {
							if(word.charAt(i) == word.charAt(r)) {
								check[i] = 1;
							}
						}
						break;
					}
				}
			}
			
			
		}
		
	}
}
//17:40

