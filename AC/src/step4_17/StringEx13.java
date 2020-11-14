package step4_17;

import java.util.Scanner;

public class StringEx13 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String name = "코끼리";
		System.out.println(name);
		System.out.print("입력 : ");
		String my = scan.next();
		
		int check = 0;
		
		if(name.length() == my.length()) {
			check = 1;
			for (int i = 0; i < name.length(); i++) {
				if(name.charAt(i) != my.charAt(i)) {
					check = 0;
				}
			}
		}
		
		if(check == 1) {
			System.out.println("True");
		}else { 
			System.out.println("False");
		}
	}

}
