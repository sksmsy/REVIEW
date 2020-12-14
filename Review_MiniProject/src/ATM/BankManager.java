package ATM;

import java.util.Scanner;

public class BankManager {

	Scanner sc = new Scanner(System.in);
	
	static BankManager instance = new BankManager();
	
	Bank bank = new Bank();
	
	void printMenu() {
		System.out.println("===="+bank.name+"====");
		System.out.println("[1]로그인");
		System.out.println("[2]회원가입");
		System.out.println("[0]종료");
	}
	
	
	void play() {
		
		FileManager.instance.load();
		UserManager.instance.printAllUser();
		
		boolean loop = true;
		
		while(loop) {
			printMenu();
			
			System.out.print("메뉴선택 > ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				login();
			}
			else if(sel == 2) {
				join();
			}
			else if(sel == 0) {
				loop = false;
			}
		}
	}
	
	
	void login() {
		bank.log = UserManager.instance.logUser();
		if(bank.log != -1) {
			loginMenu();
		}else {
			System.out.println("ID 또는 PW를 확인해 주세요.");
		}
	}
	
	void join() {
		UserManager.instance.joinMember();
	}
	
	void loginMenu() {
		boolean loop = true;
		
		while(loop) {
			System.out.println("[" + UserManager.instance.user[bank.log].id + "님]");
			System.out.println("[1]계좌생성");
			System.out.println("[2]계좌삭제");
			System.out.println("[3]조회");
			System.out.println("[4]회원탈퇴");
			System.out.println("[5]로그아웃");
			System.out.print("메뉴 선택 > ");
			int sel = sc.nextInt();
			
			
			if(sel == 1) {
				AccountManager.instance.createAcc(bank.log);
			}
			else if(sel == 2) {
				AccountManager.instance.deleteAcc(bank.log);
			}
			else if(sel == 3) {
				AccountManager.instance.printAcc(bank.log);
			}
			else if(sel == 4) {
				UserManager.instance.deleteMember(bank.log);
				loop = false;
			}
			else if(sel == 5) {
				bank.log = -1;
				loop = false;
			}
		}
	}
}
