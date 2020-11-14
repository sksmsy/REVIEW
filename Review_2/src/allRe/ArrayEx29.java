package allRe;

import java.util.Scanner;

public class ArrayEx29 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		int com[] = {1, 7, 3};
		int me [] = new int[3];
		
		int  n = 0;
		while(true) {
			
			int b = 0;
			int s = 0;
			
			for (int i = 0; i < me.length; i++) {
				System.out.print("["+(i+1)+"]"+"숫자입력(1~9) : ");
				int num = scan.nextInt();
				
				int check = 1;
				for (int j = 0; j < i; j++) {
					if(num == me[j]) {
						check = -1;
					}
				}
				
				if(check == -1) {
					i -= 1;
				}else {
					me[i] = num;
				}
				
			}
			
			for (int i = 0; i < me.length; i++) {
				for (int j = 0; j < me.length; j++) {
					if(me[i] == com[j]) {
						if(i == j) {
							s += 1;
						}else {
							b +=1;
						}
					}
				}
			}
			System.out.println("B = " + b +" ," + "S = "+ s);
			if(s== 3) {
				break;
			}
			
			
		}
		
		
	}

}
