package step3;

import java.util.Scanner;

import java.util.Random;

/*
 * 1 to 8
 */

public class ArrayEx25 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		int arr[] = new int[9];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		for (int i = 0; i < 1000; i++) {
			int r = ran.nextInt(9);
			int temp = arr[0];
			arr[0] = arr[r];
			arr[r] = temp;
		}
		
		int num = 0;
		while(true) {
			
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "   ");
				
				if(i % 3 == 2) {
					System.out.println();
				}
			}
			
			
			System.out.print("입력 : ");
			int my = scan.nextInt();
			
			if(arr[my] == num) {
				arr[my] = 0;
				num += 1;
			}
			
			if(num == 8) {
				break;
			}
			
		}
		
	}

}
