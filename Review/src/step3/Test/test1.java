package step3.Test;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		int a[] = {10, 4, 5, 3, 1};
		
		//ex1) 위 배열을 이용해서 전체 합 출력 
		
		int tot = 0 ;
		for (int i = 0; i < a.length; i++) {
			tot += a[i];
		}System.out.println(tot);
		
		//ex2) 다음 리스트를 값을 입력하면 인덱 출력
		
		System.out.print("Data : ");
		int num = scan.nextInt();
		
		for (int i = 0; i < a.length; i++) {
			if(num == a[i]) {
				System.out.print("Data Idx : " + i);
			}
		}
		System.out.println();
		
		//ex3) 다음 리스트를 이용해서 a의 값 중 홀수만 b에 저장(동일한 위치에 저장)
		int b[] = new int[5];
		
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] % 2 == 1) {
				b[i] = a[i];
			}
		}
		
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
		//ex4) 다음 리스트를 이용해서 a의 값중 홀수만 c에 저장 (위치는 앞에서부터 저장)
		
		int c[] = new int[5];
		
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] % 2 == 1) {
				c[j] = a[i];
				j+= 1;
			}
		}
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
	}

}
