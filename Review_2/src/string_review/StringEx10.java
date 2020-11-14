package string_review;

import java.util.Scanner;

public class StringEx10 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String str = "자전거";
		
		while(true) {
			System.out.println("제시어 : "+ str);
			int size = str.length();
			
			System.out.print( "입력 : ");
			String word = scan.next();
			
			if(str.charAt(size-1) == word.charAt(0)) {
				str = word;
			}
		
		}
		
	}

}
