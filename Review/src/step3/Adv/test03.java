package step3.Adv;

import java.util.Scanner;
/*
 * # 소수찾기 (3)
 * 1. 숫자를 한개 입력받는다.
 * 2. 입력받은 숫자보다 큰 첫번째 소수를 출력한다.
 * 
 */
public class test03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Number  ");
		int num = scan.nextInt();
		
		
		for (int i = num; i < num+50; i++) {
			int cnt = 0;
			for (int j = 1; j < num+50; j++) {
				if(i % j == 0) {
					cnt += 1;
				}	
			}
			if(cnt == 2) {
				System.out.print(i+" ");
				break;
				
			}
			
		}
	}

}
