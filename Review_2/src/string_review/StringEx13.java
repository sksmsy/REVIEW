package string_review;

import java.util.Scanner;

public class StringEx13 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String str = "코끼리";
		
		System.out.println(str);
		System.out.print("입력 : ");
		String my = scan.next();
		
		int check = 0;
		if(str.length() == my.length()) {
			check = 1;
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != my.charAt(i)) {
					check = -1;
				}
			}
		}
		
		if(check == 1) {
			System.out.println("True");
		}else { 
			System.out.println("False");
		}
	}

}
