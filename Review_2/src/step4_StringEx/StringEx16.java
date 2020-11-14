package step4_StringEx;

import java.util.Scanner;

public class StringEx16 {

	public static void main(String[] args) {
		
		Scanner scan  = new Scanner(System.in );
		
		String text = "Life is too short";
		System.out.println(text);
		
		System.out.print("검색할 단어 : ");
		String word = scan.next();
		
		char arr[] = new char [text.length()];
		for (int i = 0; i < text.length(); i++) {
			arr[i] = text.charAt(i);
		}
		
		int size = word.length();
		int check = 0;
		for (int i = 0; i < arr.length-size+1; i++) {
			int cnt = 0;
			for (int j = 0; j < size; j++) {
				if(arr[i+j] == word.charAt(j)) {
					cnt += 1;
				}
			}
			
			if(cnt == size) {
				check = 1;
			}
		}
		
		
		if(check ==1) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
	}

}
