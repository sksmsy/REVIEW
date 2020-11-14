package step5_test;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String text ="Life is too short.";
		
		System.out.println(text);
		
		System.out.print("변경할 단어 : ");
		String word = scan.next();
		
		
		
		char arr[] = new char[text.length()];
		for (int i = 0; i < text.length(); i++) {
			arr[i] = text.charAt(i);
		}

		
		int size = word.length();
		int check = -1;
		int idx = 0;
		
		for (int i = 0; i < arr.length-size; i++) {
			int cnt = 0;
			for (int j = 0; j < size; j++) {
				if(arr[i+j] == word.charAt(j)) {
					cnt+= 1;
				}
			}
			
			if(cnt == size) {
				check = 1;
				idx = i;
			}
		}

		if(check == 1) {
			int fIdx = idx;
			int lIdx = idx+size;
			
			
			System.out.println("단어 : ");
			String change = scan.next();
			
			char temp[] = arr;
			
			String f = "";
			for (int i = 0; i < fIdx; i++) {
				f += temp[i];
			}
			
			String b ="";
			for (int i = lIdx; i < temp.length; i++) {
				b += temp[i];
			}
			
			
			String result = f + change + b;
			System.out.println(result);
		}else {
			System.out.println("해당 단어가 존재하지 않습니다.");
		}
		
	}

}
//1528

//1550