package step4_StringEx;

import java.util.Scanner;

/*
 * # 문자열 비교
 * equals 메서드 없이 문자의 일치여부 비교
 */
public class StringEx13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String name= "코끼리";
		
		System.out.print("입력 : ");
		String my = scan.next();
		int cnt = 0;
		for (int i = 0; i < name.length(); i++) {
			if(my.charAt(i) == name.charAt(i)) {
				cnt += 1;
			}
		}
		
		if(cnt == name.length()) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	
	}

}
