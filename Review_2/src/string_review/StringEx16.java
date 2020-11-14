package string_review;

import java.util.Scanner;

import javax.xml.soap.Text;

public class StringEx16 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		String txt = "Life is too short";
		System.out.println(txt);
		
		System.out.print("검색 : ");
		String word = scan.next();
		

		char arr[] = new char[txt.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = txt.charAt(i);
		}
		
		int size = word.length();
		int check = -1;
		for (int i = 0; i < arr.length-size+1; i++) {
			int cnt = 0;
			for (int j = 0; j < size; j++) {
				if(arr[i+j] == word.charAt(j)) {
					cnt += 1;
				}
			}
			if(cnt ==size) {
				check = 1;
			}
		}
		
		
		if(check == 1) {
			System.out.println("true");
		}else {
			System.out.println("False");
		}
		
	}

}
