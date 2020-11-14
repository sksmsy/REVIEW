package step8;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println(list);
			System.out.println("1.추가 2.삭제 3.삽입 4.종료");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("추가할 숫자 >>");
				int num = sc.nextInt();
				list.add(num);
			}else if(sel == 2) {
				System.out.println(list);
				System.out.println("삭제할 인덱스 >>");
				int idx = sc.nextInt();
				if(list.size() <= 0) {
					continue;
				}
				if(idx < 0) {
					continue;
				}
				if(idx >= list.size()) {
					continue;
				}
				list.remove(idx);
			}
			else if(sel == 3) {
				System.out.println(list);
				System.out.println("삽입 위치 >>");
				int pos = sc.nextInt();
				System.out.println("삽입 값 >>");
				int value = sc.nextInt();
				list.add(pos, value);
			}
			else if(sel == 4) {
				System.out.println("종료");
				break;
			}
		}
	}

}
