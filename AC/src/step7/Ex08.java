package step7;

import java.util.Scanner;

class User{
	String id; 
	int money;
}

public class Ex08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int max = 100;
		User [] user = new User[max];
		for (int i = 0; i < user.length; i++) {
			user[i] = new User();
		}
		int cnt = 0;
		int n = 0;
		
		while (n == 0) {
			System.out.println("1.회원가입");
			System.out.println("2.탈퇴");
			System.out.println("3.출력");
			int sel = sc.nextInt();
			if(sel == 1) {
				System.out.print("이름 : ");
				user[cnt].id = sc.next();
				System.out.print("금액 : ");
				user[cnt].money = sc.nextInt();
				cnt += 1;
			}
			if(sel == 2) {
				System.out.print("인덱스 : ");
				int idx = sc.nextInt()-1;
				for (int i = idx; i < cnt-1; i++) {
					user[i] = user[i + 1];
				}
				cnt -= 1;
			}
			if(sel == 3) {
				for (int i = 0; i < cnt; i++) {
					System.out.println(i+1+")" + user[i].id + " : " + user[i].money);
				}
			}
		}
	}

}
