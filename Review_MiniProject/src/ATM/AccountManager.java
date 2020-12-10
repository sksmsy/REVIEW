package ATM;

import java.util.Random;
import java.util.Scanner;

public class AccountManager {
	
	static AccountManager instance = new AccountManager();
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	
	void createAcc(int log) {
		
		int cnt = UserManager.instance.user[log].accCnt;
		
		
		if(cnt == 3) {
			System.out.println("[메세지] 더 이상 계좌를 생성 할 수 없습니다.");
			return;
		}
		
		UserManager.instance.user[log].acc[cnt] = new Account();
		
		boolean result = true;
		int account = 0;
		
		while(result) {
			account = ran.nextInt(900000)+100000;
			result = UserManager.instance.getCheckAcc(account);
		}
		
		UserManager.instance.user[log].acc[cnt].num = account;
		UserManager.instance.user[log].accCnt +=1;
	}
	
	void deleteAcc(int log) {
		
		int cnt = UserManager.instance.user[log].accCnt;
		
		if(cnt == 0) {
			System.out.println("삭제할 계좌가 없습니다.");
			return;
		}
		
		printAcc(log);
		System.out.println("삭제할 계좌 > ");
		int sel = sc.nextInt();
		
		Account[] temp = UserManager.instance.user[log].acc;
		UserManager.instance.user[log].acc = new Account[cnt-1];
		
		
		
		
		UserManager.instance.user[log].accCnt -= 1;
		
	}
	
	void printAcc(int log) {
		User temp = UserManager.instance.user[log];
		System.out.println("ID : " + temp.id);
		System.out.println("PW : " + temp.pw);
		for (int i = 0; i < temp.accCnt; i++) {
			System.out.println(temp.acc[i].num + " : " + temp.acc[i].money );
		}
	}
	
	
}
