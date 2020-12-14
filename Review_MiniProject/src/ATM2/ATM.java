package ATM2;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	
	static Scanner sc = new Scanner(System.in);
	static Random ran = new Random();
	
	FileManager fileManager = new FileManager.instance;
	UserManager userManager = new UserManager.instance;
	static int log;
	
	
	ATM() {
		log = -1;
		
		boolean rs = fileManager.loadData();
		
		if(!rs) {
			userManager.setDummy();
			fileManager.saveData();
		}
	}

	
	void menu() {
		while(true) {
			
			userManager.printAllUserInfo();
			
			System.out.println("ATM");
			System.out.println("[1]LogIn");
			System.out.println("[2]Join");
			System.out.println("[0]Close");
			System.out.print(">> ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				login();
			}else if(sel == 2) {
				join();
			}else if(sel == 0) {
				break;
			}
		}
	}
	
	void loginMenu() {
		while(true) {
			System.out.println("[" + userManager.userList[log].id + "님, 로그인]");
			System.out.println("[1]계좌생성");
			System.out.println("[2]입금하기");
			System.out.println("[3]출금하기");
			System.out.println("[4]이체하기");
			System.out.println("[5]계좌조회");
			System.out.println("[6]계좌삭제");
			System.out.println("[7]회원탈퇴");
			System.out.println("[0]로그아웃");
			System.out.print(">> ");
			int sel = sc.nextInt();
			
			if(sel == 1) {createAccount();}
			else if(sel ==2) {income();}
			else if(sel ==3) {withdraw();}
			else if(sel ==4) {transfer();}
			else if(sel ==5) {lookupAcc();}
			else if(sel ==6) {deleteAcc();}
			else if(sel ==7) {leave();}
			else if(sel ==0) {
				log = -1;
				System.out.println("로그아웃 완료");
				break;
			}
		}
	}

	void login() {
		System.out.println("[로그인] ID : ");
		String id = sc.next();
		
		System.out.println("[로그인] PW : ");
		String pw = sc.next();
		
		for (int i = 0; i < userManager.userCnt; i++) {
			User temp = userManager.userList[i];
			if(temp.id.equals(id) && temp.pw.equals(pw)) {
				log = i;
			}
		}
		
		if(log == -1) {
			System.out.println("ID 또는 PW를 확인해주세요.");
		}else {
			System.out.println(userManager.userList[log].id + "님 로그인");
		}
		loginMenu();
	}
	
	void join() {userManager.joinUser();}
	
	void createAccount() {userManager.createAccount();}
	
	void leave() {userManager.leaveUser();}
	
	void income() {userManager.income();}
	
	void withdraw() { userManager.outcome();}
	
	void transfer() {userManager.transfer();}
	
	void lookupAcc() {userManager.lookupAcc();}
	
	void deleteAcc() {userManager.deleteAcc();}
	
}

