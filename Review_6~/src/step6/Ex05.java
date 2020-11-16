package step6;

import java.util.Scanner;

class Ex5{
	String name = "";
	
	
	int [] id = {1001,1002,1003,1004,1005};
	int [] scr = {92, 38, 87, 100, 11};
}

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex5 e5 = new Ex5();
		
		
		while(true) {
			System.out.println("====="+e5.name+"=====");
			System.out.println("1.전교생 성적 확인");
			System.out.println("2.1등학생 성적 확인");
			System.out.println("3.꼴등학생 성적 확인");
			System.out.println("4.성적 확인");
			System.out.println("5.종료");
			
			System.out.print(">>>");
			int sel = sc.nextInt();

			if(sel == 1) {
				for (int i = 0; i < e5.id.length; i++) {
					System.out.println(e5.id[i] + " : " + e5.scr[i]);
				}
				
			}
			else if(sel == 2) {
				
				int top = 0;
				int topIdx = 0;
				
				for (int i = 0; i < e5.id.length; i++) {
					if(top < e5.scr[i] ) {
						top = e5.scr[i];
						topIdx = i;
					}
				}
				
				System.out.println(e5.scr[topIdx]);
			}
			else if(sel == 3) {
				int wor = 100;
				int worIdx = 0;
				
				for (int i = 0; i < e5.id.length; i++) {
					if(wor > e5.scr[i]) {
						wor = e5.scr[i];
						worIdx = i;
					}
				}
				
				System.out.println(e5.scr[worIdx]);
			}
			else if(sel == 4) {
				System.out.println("ID : ");
				int myId = sc.nextInt();
				
				int check = -1;
				for (int i = 0; i < e5.id.length; i++) {
					if(myId == e5.id[i]) {
						check = i;
					}
				}
				
				if(check > -1) {
					System.out.println(e5.scr[check]);
				}else {
					System.out.println("없는ID");
				}
			}
			else if(sel == 5) break;
		}
		
		
		
	}

}
