package step4_17;

import java.util.Random;
import java.util.Scanner;

public class StringEx12 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		
		String word [] = {"java", "mysql", "jsp","spring"};
	
		for (int i = 0; i < 30; i++) {
			int r = ran.nextInt(word.length);
			
			String temp = word[0];
			word[0] = word[r];
			word[r] = temp;
		}
		
		
		int j = 0;
		while(j <word.length ) {
			
			int r = ran.nextInt(word[j].length());
			for (int i = 0; i < word[j].length(); i++) {
				
				if(i == r ) {
					System.out.print("*");
				}else {
					System.out.print(word[j].charAt(i));
				}
			}
			System.out.println();
			
			System.out.print("입력 : ");
			String my = scan.next();
			
			
			if(word[j].equals(my)) {
				j ++;
			}
		}
		
		
		
	}

}
