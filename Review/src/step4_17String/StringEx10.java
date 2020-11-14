package step4_17String;

import java.util.Scanner;

/*
 * #끝말잇기
 * 제시어 : 자전거 
 * 입력 : 거미
 * 제시어 : 거미
 * 입력 : 미술
 * 
 * ...
 */

public class StringEx10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String word = "자전거";
		System.out.println("제시어 : " + word);
		
		
		while(true) {
			
			int size = word.length();
			
			System.out.print(" : ");
			String answer = scan.next();
			
			if(answer.length() == 1) {
				System.out.println("2글자 이상 입력");
				continue;
			}
			
			if(word.charAt(size-1) == answer.charAt(0)) {
				 word = answer;
				 System.out.println(word);
			}else {
				
				System.out.println("땡");
			}
			
		}
		
		
		
		
	}

}
