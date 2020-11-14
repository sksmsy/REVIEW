package step4_StringEx;

import java.util.Scanner;

public class StringEx10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String word = "자전거";
		
		while(true) {
			int size = word.length();
			
			System.out.println("제시어 : " + word);
			System.out.print(" : " );
			String my = scan.next();
			
		
			if(word.charAt(size -1 ) == my.charAt(0)) {
				word = my ;
			}else {
				System.out.println("땡");
			}
			
		}
	}

}
