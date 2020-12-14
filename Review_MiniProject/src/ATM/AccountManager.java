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
		
		if(cnt == 1) {
			UserManager.instance.user[log].acc = null;
			
		}else if(cnt > 1) {
			printAcc(log);
			
			System.out.println("삭제할 계좌를 선택하세요");
			int sel = sc.nextInt()-1;

			Account temp[] = UserManager.instance.user[log].acc;
			UserManager.instance.user[log].acc = new Account[cnt -1];
			
			int j = 0;
			for (int i = 0; i < cnt; i++) {
				if(i != sel) {
					UserManager.instance.user[log].acc[j] = new Account();
					UserManager.instance.user[log].acc[j] = temp[i];
					j+=1;
				}
			}
			
			
		}
		
		UserManager.instance.user[log].accCnt -= 1;
		System.out.println("삭제 완료");
		
	}
	
//	int j = 0;
//    for (int i = 0; i < cnt; i++) {
//       System.out.println(j + " " + sel);
//       if(i != sel) {
//       //   UserManager.instance.user[log].acc[j] = new Account();
//          UserManager.instance.user[log].acc[j] = temp[i];
//          System.out.println(UserManager.instance.user[log].acc[j].num);
//          j+=1;
//       }
//    }

	
	void printAcc(int log) {
		User temp = UserManager.instance.user[log];
		System.out.println("ID : " + temp.id);
		System.out.println("PW : " + temp.pw);
		if(temp.accCnt == 0) {
			System.out.println("보유하고 있는 계좌가 없습니다.");
		}
		
		for (int i = 0; i < temp.accCnt; i++) {
			System.out.println("["+(i+1)+"]"+temp.acc[i].num + " : " + temp.acc[i].money );
		}
	}
	
	
}
