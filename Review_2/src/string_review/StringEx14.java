package string_review;

import java.util.Scanner;

public class StringEx14 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력 : ");
		String text = scan.next();
			
		char a[] = {'0', '1','2','3','4','5','6','7','8','9'};
		
		int check = 0;
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < a.length; j++) {
				if(text.charAt(i) == a[j]) {
					check += 1;
				}
			}
		}
		
		
		if(check == text.length()) {
			System.out.println("숫자");
		}else if(check == 0) {
			System.out.println("문자");
		}else {
			System.out.println("문자 + 숫자 ");
		}
	}

}
