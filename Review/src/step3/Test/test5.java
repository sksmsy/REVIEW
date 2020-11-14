package step3.Test;

import java.util.Scanner;

public class test5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//ex1) 아래 배열a에서 내가 입력한 값만 빼고 b에 저장
		int a[] = { 10,20,30,40,50};
		int b[] = new int[5];
		
		System.out.print("Data : ");
		int data = scan.nextInt();
		
		int check = -1;
		for (int i = 0; i < a.length; i++) {
			if(data == a[i]) {
				check = i;
			}
		}
		int j = 0 ;
		for (int i = 0; i < 5; i++) {
			if(check != i) {
				b[j] = a[i];
				j+=1;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.print(b[i] + " ");
		}
		
		System.out.println();
		
		//ex2) 아래 배열에서 내가 입력한 번호만 빼고 d에 저장
		int c[] = { 1001,40, 1002,65, 1003,70};
		int d[] = new int[6];
		
		System.out.print("Data : ");
		int data2 = scan.nextInt();
		
		check = -1 ;
		for (int i = 0; i < d.length; i++) {
			if(data2 == c[i]) {
				check = i;
			}
		}
		j = 0;
		for (int i = 0; i < d.length; i++) {
			if(i != check) {
				d[j] = c[i];
				j+=1;
			}
		}
		
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i]+ " ");
			
		}
	}

}
