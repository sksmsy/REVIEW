package step4_StringEx;

import java.util.Random;
import java.util.Scanner;

public class StringEx11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		String word[] = {"java", "mysql","jsp","spring"};
		
		
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(word.length);
			
			String temp = word[0];
			word[0] = word[r];
			word[r] = temp;
			
		}
		
		int j = 0;
		while(j<4) {
			
			System.out.println("문제 : " + word[j]);
			System.out.print("입력 : ");
			String my = scan.next();
			
			if(my.equals(word[j])) {
				j ++;
			}
		}
		
	}

}
