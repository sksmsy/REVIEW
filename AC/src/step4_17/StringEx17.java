package step4_17;

import java.util.Scanner;

public class StringEx17 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String text = "Life is too short";
		System.out.println(text);
		
		System.out.print("검색할 단어 : ");
		String word = scan.nextLine();
		
		char c [] = new char[text.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = text.charAt(i);
		}
		
		int fIdx =0;
		int lIdx =0;
		
		int size = word.length();
		int check = 0;
		for (int i = 0; i < c.length-size+1; i++) {
			int cnt = 0;
			for (int j = 0; j < size; j++) {
				if(c[i+j] == word.charAt(j)) {
					cnt ++;
				}
			}
			if(cnt == size) {
				check = 1;
				fIdx = i;
				lIdx = size + i;
			}
		}
		
		
		if(check == 1) {
			
			System.out.print("바꿀 단어 : ");
			String change = scan.nextLine();
			

			char temp [] = c;
			String front = "";
			 for (int i = 0; i < fIdx; i++) {
				front += temp[i];
			}
			 
			 String back = "";
			 for (int i = lIdx; i < temp.length; i++) {
				back += temp[i];
			}
			
			 
			 String result = front + change + back;
			 
			 System.out.println(result);
			 
			 
			
		}else {
			System.out.println("FALSE");
		}
		
	}

}
