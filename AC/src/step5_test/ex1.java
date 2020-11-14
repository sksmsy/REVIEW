package step5_test;

import java.util.Random;
import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		// 16:10
		
		String word[] = {"java" , "mysql" , "jsp", "spring"};
		
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(4);
			
			String temp = word[0];
			word[0] = word[r];
			word[r] = temp;
		}
		
		
		
		int j = 0;
		while(j < 4) {
			
			int leng = word[j].length();
			int r = ran.nextInt(leng);
			
			for (int i = 0; i < leng; i++) {
				if(i == r){
					System.out.print("*");
				}else {
					System.out.print(word[j].charAt(i));
				}
			}
			System.out.println();
			System.out.print("입력 : ");
			String answer = scan.next();
			
			if(answer.equals(word[j])) {
				j++;
			}
			
		}

	}

}

//16:23