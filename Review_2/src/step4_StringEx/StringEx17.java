package step4_StringEx;

import java.util.Scanner;

/*
 *# 단어교체
 *1.text변수 문장 속에서 변경하고 싶은 단어를 입력받아
 *2. 교체하는 기능을 구현한다
 */
public class StringEx17 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String text= "Life is too short";
		System.out.println(text);
		
		System.out.print("변경하고 싶은 단어를 입력 :");
		String word = scan.nextLine();
		
		char [] arr = new char[text.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = text.charAt(i);
		}
			
		int size = word.length();
		int check = 0;
		int idx = 0;
		for (int i = 0; i < arr.length-size +1; i++) {
			int cnt = 0;
			for (int j = 0; j < size; j++) {
				if(arr[i+j] == word.charAt(j)){
					cnt += 1;
				}
			}
			if(cnt == size) {
				check = 1;
				idx = i;
			}
		}
		
		
		if(check == 1) {
			int firstIdx = idx;
			int lastIdx = idx+size;
			
			System.out.print("바꿀 단어 입력 : ");
			String change = scan.nextLine();
			
			String front = "";
			char temp [] = arr;
			for (int i = 0; i < firstIdx; i++) {
				front += temp[i];
			}
			
			String back = "";
			for (int i = lastIdx; i < temp.length; i++) {
				back += temp[i];
			}
			
			text = front+change+back;
			System.out.println(text);
			
		}
		
	}

}
