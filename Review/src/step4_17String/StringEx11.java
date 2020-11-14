package step4_17String;

import java.util.Random;
import java.util.Scanner;

/*
 * #타자연습(1)
 * 1.문제를 석는다.
 * 2. 순서대로 문제를 출제하고 문제를 다 풀면 게임 종료
 */
public class StringEx11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		String java[] = {"java", "mysql", "jsp", "spring"};
		
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(4);
			
			String temp = java[0];
			java[0] = java[r];
			java[r] = temp;
			
		}
		
		int j = 0;
		while(j < 4) {
			
			System.out.println("문제 : " + java[j]);
			
			System.out.print("입력 : ");
			String my = scan.next();
			
			if(java[j].equals(my)) {
				j++;
			}
			
			
			
		}
		
		
	}

}
