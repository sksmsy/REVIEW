package string_review;

import java.util.Random;
import java.util.Scanner;

public class StringEx11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		String word[] = {"java", "mysql","jsp","spring"};
		
		
		for (int i = 0; i < 40; i++) {
			int r = ran.nextInt(word.length);
		
			String temp = word[0];
			word[0] = word[r];
			word[r] = temp;
		}
		
		int j = 0;
		while(j < word.length) {
			System.out.println(word[j]);
			System.out.print("입력 : ");
			String my = scan.next();
			
			if(word[j].equals(my)) {
				j++;
			}
			
		}
		
		
	}

}
