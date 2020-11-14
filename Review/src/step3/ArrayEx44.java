package step3;

import java.util.Scanner;

public class ArrayEx44 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[][] items = new String[5][2];
		for(int i=0; i<items.length; i++) {
			items[i][0] = "";
			items[i][1] = "";
		}
		
		int cnt = 0;
		
		while(true) {

			System.out.println("[관리자 모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아 이 템  관리");
			System.out.println("[3]전체품목 출력");
			
			System.out.print(": ");
			int sel = scan.nextInt();
			
			
			
			if(sel == 1) {
				System.out.print("카테고리 추가 : ");
				String category = scan.next();
				
				items[cnt][0] = category;
				cnt += 1;
				
			}
			else if(sel == 2) {
				for (int i = 0; i < cnt; i++) {
					System.out.print("["+ (i+1)+"]" + items[i][0]);
				}System.out.println();
				
				System.out.print("카테고리 선택 : ");
				int category = scan.nextInt();
				
				System.out.print("아이템 추가 : ");
				String item = scan.next();
				
				items[category -1 ][1] += item;
				items[category -1 ][1] += "/";
				
			}
			else if(sel == 3) {
				for (int i = 0; i < items.length; i++) {
					System.out.println(items[i][0] + ", "+ items[i][1]);
				}
			}

		}
		
	}

}
