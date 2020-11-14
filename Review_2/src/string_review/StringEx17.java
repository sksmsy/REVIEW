package string_review;

import java.util.Scanner;

public class StringEx17 {

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
		int idx = 0;
		for (int i = 0; i < arr.length-size+1; i++) {
			int cnt = 0;
			for (int j = 0; j < size; j++) {
				if(arr[i+j] == word.charAt(j)) {
					cnt += 1;
				}
			}
			if(cnt ==size) {
				idx = i;
				check = 1;
			}
		}
		
		
		if(check == 1) {
			int fIdx = idx;
			int lIdx = idx+size;
			
			System.out.print("바꿀 단어 : ");
			String change = scan.nextLine();
			 
			char temp [] = arr;
			String front = "";
			for (int i = 0; i < fIdx; i++) {
				front += temp[i];
			}
			
			String back ="";
			for (int i = lIdx; i < temp.length; i++) {
				back += temp[i];
			}
			
			String result = front + change + back;
			System.out.println(result);
			
		}else {
			System.out.println("False");
		}
	}

}
