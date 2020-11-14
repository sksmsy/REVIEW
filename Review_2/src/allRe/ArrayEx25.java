package allRe;

import java.util.Random;
import java.util.Scanner;

public class ArrayEx25 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		int arr[] = new int[9] ;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(9);
			
			int temp = arr[0];
			arr[0] = arr[r];
			arr[r] = temp;
			
		}
		
		int cnt = 1;
		while(true) {
			System.out.println("[" + cnt + "]");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "   ");
				
				if(i % 3 == 2) {
					System.out.println();
				}
			}
			
			System.out.print("입력 : ");
			int num = scan.nextInt();
			
			if(arr[num] == cnt ) {
				arr[num] = 0;
				cnt += 1;
			}
			
			if(cnt == 10) {
				break;
			}
			
			
		}
	}

}
