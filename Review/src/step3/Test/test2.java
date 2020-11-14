package step3.Test;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		//ex1) 인덱스를 입력하면 값 출력 
		int a[] = {10,20,30,40,50};
		
		System.out.print("Idx : ");
		int idx = scan.nextInt();
		
		System.out.println(a[idx]);
		
		//ex2) 아래 배열중 가장 큰 값 출력
		
		int b[] = {12,54,23,87,1};
		
		int maxNum =0 ;
		for (int i = 0; i < b.length; i++) {
			if(maxNum < b[i]) {
				maxNum = b[i];
			}
		}System.out.println(maxNum);
		
		//ex3) 아래 배열중 홀수의 개수 출력
		
		int c[] = {12, 54, 23, 87, 1};
		
		int cnt = 0;
		for (int i = 0; i < c.length; i++) {
			if(c[i] % 2 == 1) {
				cnt +=1 ;
			}
		}System.out.println(cnt);
		
		
		//ex4) 아래배열을 거꾸로 저장
		int d[] = {1,2,3,4,5};
		int e[] = new int[5];
		
		int j = 4;
		for (int i = 0; i < e.length; i++) {
			e[j] = d[i];
			j -= 1;
		}
		for (int i = 0; i < e.length; i++) {
			System.out.print(e[i] + " ");
		}
	}

}
