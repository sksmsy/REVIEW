package step3.Adv;

import java.util.Scanner;

public class Adv04 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//ex1) 1~백만 사이의 숫자를 입력받고 가운데 숫자 출력
		// 단, 짝수자리의 수는 짝수자리라고  출력
		// 예) 123 == 2
		// 예) 1234 ==> 짝수자리
		// 예) 1 ==> 1
		// 예) 1234567 ==> 4
		
		
		System.out.print("num : ");
		int num = scan.nextInt();
	
		
		int leng = (int)(Math.log10(num)+1);
		
		if(leng % 2 == 0) {
			System.out.println("짝수자리");
		}else {
		
			int arr[] = new int[leng];
			int k = 1;
			for (int i = 0; i < leng; i++) {
				arr[i] = (num / k) % 10;
				k *= 10;
			}
			
			System.out.println(arr[leng/2]);
		}
		
		
	}

}
