package step4_17String;

import java.util.Random;
import java.util.Scanner;

/*
 * #타자연습 (2)
 * 1.문제를 섞는다
 * 2. 순서대로 문제를 출제, 다맞추면 게임 종료
 * 3. 단 문제를 출제할때 단어의 랜덤한 위치 한곳만 *로 출력
 * 
 */
public class StringEx12 {

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

			int size = java[j].length();
			int r = ran.nextInt(size);
			System.out.print("문제 : ");
			for (int k = 0; k < size; k++) {
				if(k == r) {
					System.out.print("*");
				}else {
					System.out.print(java[j].charAt(k));
				}
			}System.out.println();
			
			System.out.print("입력 : ");
			String my = scan.next();
			
			if(java[j].equals(my)) {
				j++;
			}
			
			
			
		}
		
		
	}

}
