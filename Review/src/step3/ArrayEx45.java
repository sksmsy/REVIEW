package step3;

import java.util.Scanner;

public class ArrayEx45 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",     "2222", "3333"};
		
		int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];
		
		int count = 0;
		
		String[] items = {"사과", "바나나", "딸기"};
		
		int log = -1;
		
		while(true) {
			
			System.out.println("[MEGA MART]");
			System.out.println("[1]로 그 인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼     핑");
			System.out.println("[4]장바구니");
			System.out.println("[0]종     료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(log != -1) {
					System.out.println("이미 로그인중.");
					continue;
				}
				
				System.out.print("ID : ");
				String myId = scan.next();
				
				System.out.print("PW : ");
				String myPw = scan.next();
				
				
				for (int i = 0; i < ids.length; i++) {
					if(myId.equals(ids[i]) && myPw.equals(pws[i])) {
						System.out.println("로그인 성공");
						log = i;
					}
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("로그인 먼저");
					
					
				}else {
					log = -1;
					System.out.println("로그아웃 성공");
				}
			}
			else if(sel == 3) {
				
				while (true) {
					System.out.println("[목록]");
					for(int i = 0; i < items.length; i++) {
						System.out.println("["+ (i+1)+"]" + items[i]);
					}
					System.out.println("[0]뒤로");
					
					System.out.print("선택 : ");
					int choice = scan.nextInt();
					
					if(choice == 0) {
						break;
					}
					
					jang[count][0] = log;
					jang[count][1] = choice;
					count += 1;
				}
			}
			else if(sel == 4) {
				
				int a = 0;
				int b = 0;
				int s = 0;
				
				for (int i = 0; i < count; i++) {
					if(jang[i][0] == log) {
						if(jang[i][1] == 1) {a += 1;}
						if(jang[i][1] == 2) {b += 1;}
						if(jang[i][1] == 3) {s += 1;}
					}
				}
				
				System.out.println(items[0] + " : " + a + "개");
				System.out.println(items[1] + " : " + b + "개");
				System.out.println(items[2] + " : " + s + "개");
			}
			else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}

}
