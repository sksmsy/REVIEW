package allRe;

import java.util.Scanner;

public class ArrayEx47 {

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
				for (int j = 0; j < jang[i].length; j++) {
					System.out.print(jang[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.print("삭제할 이름 : ");
			String name = scan.next();
			
			System.out.print("삭제할 인덱스 : ");
			int idx = scan.nextInt();
			
			int delIdx = -1;
			
			int cnt = 0;
			for (int i = 0; i < jang.length; i++) {
				if(name.equals(jang[i][0])) {
					if(idx == cnt) {
						delIdx = i;
					}
					cnt += 1;
				}
			}
			
			
			System.out.println(delIdx);
			String temp [][] = jang;
			jang = new String[temp.length-1][2];
			
			int j =0;
			for (int i = 0; i < temp.length; i++) {
				if(delIdx != i) {
					jang[j] = temp[i];
					j+=1;
				}
			}
			
		
		}
		
	}

}
