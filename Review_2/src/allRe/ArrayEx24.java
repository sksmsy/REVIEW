package allRe;

import java.util.Random;
import java.util.Scanner;

public class ArrayEx24 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int arr[] = new int[5] ; 

		
		for (int i = 0; i < arr.length; i++) {
			int r = ran.nextInt(100);
			
			arr[i] = r;
			
		}
		
		
		int cnt = 0;
		while(true) {
			int maxNum = 0;
			int maxIdx = 0;
			for (int j = 0; j < arr.length; j++) {
				if(maxNum < arr[j]) {
					maxNum = arr[j];
					maxIdx = j;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+ " ");
			}
			System.out.println();
			
			System.out.print("최대값 : ");
			int num = scan.nextInt();
			
			if(maxNum == num) {
				arr[maxIdx] = 0;
				cnt += 1;
			}
			
			if(cnt == 5) {
				break;
			}
			
		}
		
	}

}
