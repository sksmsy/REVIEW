package step3;

import java.util.Scanner;

/*
 * # 최대값 구하기
 */

public class ArrayEx24 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int arr[] = {11, 87, 42, 100, 24};
		
		
		int cnt = 0;
		while(true) {
			
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			
			int maxNum = 0 ;
			int maxIdx = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if(maxNum < arr[i]) {
					maxNum = arr[i];
					maxIdx = i;
				}
			}
			

			System.out.print("최대값 입력 : ");
			int num = scan.nextInt();
			
			if(num == maxNum) {
				arr[maxIdx] = 0;
				cnt += 1;
			}
			if(cnt == 5) {
				break;
			}
		}
		
	}

}
