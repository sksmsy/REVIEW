package step3.Test;

import java.util.Scanner;

public class test5_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int arr[] = {10, 20, 30, 40, 50};
		
		int b[] = new int[5];
		
		//숫자를 5개 입력받고 arr 배열안에 입력한 값이 있을때마다
		//b배열안에 해당 값의인덱스를 차례대로 저장하려고 한다.
		//조건 ) 만약 입력한 숫자가 arr 배열에 없으면 인덱스 대신 -1저장.
		
		//예) 10,20,10,1,50
		// b = {0,1,0,-1,4}
		int temp[] = new int[5];
		
		for (int i = 0; i < b.length; i++) {
			System.out.print("Data["+(i+1)+"] : ");
			int data = scan.nextInt();
			temp[i] = data;			
			
			
			int check = -1;
			for (int j = 0; j < temp.length; j++) {
				if(data == arr[j]) {
					check = j;
				}
			}
			
			if(check > -1) {
				b[i] = check;
			}else {
				b[i] = -1;
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			System.out.print(b[i] + " ");
		}
		
	}
}
