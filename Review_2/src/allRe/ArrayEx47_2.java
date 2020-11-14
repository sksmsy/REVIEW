package allRe;

import java.util.Scanner;

public class ArrayEx47_2 {

	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
		
		String[][] jang = {
				{"철수", "소고기"},
				{"철수", "김밥"},
				{"영희", "김치"},
				{"철수", "바나나"},
				{"철수", "새우깡"},
				{"영희", "오징어"},
				{"영희", "맛밤"}
			};

		
		while(true) {
		
			for (int i = 0; i < jang.length; i++) {
				System.out.println(jang[i][0] +", "+ jang[i][1]);
			}
			
			
			System.out.print("name : ");
			String name = scan.next();
			
			System.out.print("idx : ");
			int idx = scan.nextInt();
			
			int cnt = 0;
			int check = -1;
			for (int i = 0; i < jang.length; i++) {
				if(name.equals(jang[i][0])) {
					if(cnt == idx) {
						check = i;
					}
					cnt += 1;
				}
			}
			
			
			String temp [][] = jang;
			jang = new String[temp.length-1][2];
			int j  = 0 ;
			for (int i = 0; i < temp.length; i++) {
				
					if(check != i) {
						jang[j] = temp[i]; 
						j ++;
					}
			}
			
			
		}
		
	}

}
