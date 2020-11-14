package step3;

import java.util.Scanner;

import java.util.Random;

/*
 * # 숫자야구
 */
public class ArrayEx29 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int com[] = { 1, 7, 3};
		int me [] = new int[3];
		
		int strike = 0;
		int ball = 0;
		
		while(true) {
			
			for (int i = 0; i < me.length; i++) {
				System.out.print(me[i] + " ");
			}
			System.out.println();
			
			for (int i = 0; i < me.length; i++) {
				System.out.print("[" + (i+1) + "]숫자 : ");
				int num = scan.nextInt();
				
				int check = 1;
				for (int j = 0; j < i; j++) {
					if(num == me[j]) {
						check = -1;
					}
				}
				
				if(check == -1) {
					i -= 1;
				}
				else {
					me[i] = num;
				}
			}
			
			
			for (int i = 0; i < me.length; i++) {
				for (int j = 0; j < me.length; j++) {
					if(me[i] == com[j]) {
						if(i == j) {
							strike += 1;
						}else if( j != i ) {
							ball += 1;
						}
					}
				}
			}
			System.out.println("strike : " + strike + ", ball : "+ball );
			
			if(strike == 3) {
				break;
			}
			
		}
		
	}

}
