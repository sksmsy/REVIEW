package step3.Test;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		//	ex1) 숫자를 하나 입력받고 아래 배열을 앞으로 하나씩 밀어낸 후 맨뒤에 저장
		int a[] = {10,20,30,40,50};
		
		System.out.print("Data : ");
		int num = scan.nextInt();
		
		for (int i = 0; i < a.length-1; i++) {
			a[i] = a[i+1];
		}
		a[4] = num;
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		//ex2) 숫자 하나를 입력받고 아래 배열을 뒤로 하나씩 밀어낸 후 맨 앞에 저장
		int b[] = {10,20,30,40,50};
		
		System.out.print("Data : ");
		int data2 = scan.nextInt();
		
		int temp[] = b;
		b = new int [5];
		
		for (int i = 1; i < temp.length; i++) {
			b[i] = temp[i - 1];
		}
		
		b[0] = data2;
		
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

}
