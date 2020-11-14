package step4_StringEx;

import java.util.Scanner;

/*
 * #문자열 속 숫자검사
 * 
 */
public class StringEx14 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력 : ");
		String text = scan.next();
		
		char num[ ] = {'0', '1','2','3','4','5','6','7','8','9'};
		
		int cnt = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < text.length(); j++) {
				if(num[i] == text.charAt(j)) {
					cnt += 1;
				}
			}
		}
		
		if(cnt == text.length()) {
			System.out.println("숫자");
		}else if(cnt == 0) {
			System.out.println("문자");
			
		}else {
			System.out.println("문자+숫자");
		}
		
	}

}
