package step4_17;

import java.util.Scanner;

public class StringEx11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String word = "자전거";
		
		
		while(true) {
			System.out.println("제시어 : " + word);
			System.out.print("입력 : ");
			String my = scan.next();
			
			if(my.length() == 1) {
				System.out.println("2글자 이상 입력해주세요");
				continue;
			}
			
			if(word.charAt(word.length()-1) == my.charAt(0)) {
				word = my;
			}
			
		}
		
	}

}
