package step6_0_class;

import java.util.Scanner;

class Ex05{
	String name="";
	
	int id[] = {1001, 1002, 1003, 1004, 1005};
	int sc[] = {92, 38, 87, 100, 11};
}

public class classEx05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Ex05 e = new Ex05();

		
		
		while(true) {
			System.out.println("================");
			System.out.println("[1]전교생 성적확인");
			System.out.println("[2]1등학생 성적");
			System.out.println("[3]꼴등학생 성적");
			System.out.println("[4]성적확인");
			System.out.println("[0]종료");
			
			int sel = sc.nextInt();
			
			if(sel == 1) {
				
				int tot = 0;
				for (int i = 0; i < e.sc.length; i++) {
					tot += e.sc[i];
					System.out.println(e.id[i] + ": " + e.sc[i]);
				}
				double avg = tot / 5.0;
				
				System.out.println(tot+ ", " + avg);
				
			}
			else if(sel == 2) {
				int top = 0;
				int topIdx = 0;
				for (int i = 0; i < e.sc.length; i++) {
					if(top < e.sc[i]) {
						top = e.sc[i];
						topIdx = i;
					}
				}
				System.out.println(e.id[topIdx] + " : " + top);	
			}
			else if(sel == 3) {
				int bot = e.sc[0];
				int botIdx =0;
				for (int i = 0; i < e.sc.length; i++) {
					if(bot > e.sc[i]) {
						bot = e.sc[i];
						botIdx = i;
					}
				}
				System.out.println(e.id[botIdx] + " : " + bot);	
			}
			else if(sel == 4) {
				System.out.println("ID : ");
				int myId = sc.nextInt();
				
				int check = -1;
				for (int i = 0; i < e.sc.length; i++) {
					if(myId == e.id[i]) {
						check = i;
					}
				}
				if(check == -1) {
					System.out.println("해당 학번은 존재하지 않습니다.");
				}
				else {
					System.out.println(e.sc[check]);
				}
				
			}
			else if(sel == 5) {
				break;
			}
			
		}
		
	}

}
