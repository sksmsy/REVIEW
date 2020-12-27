package ATM2_re;

import java.util.Random;
import java.util.Scanner;

public class ATM {

	static Scanner sc = new Scanner(System.in);
	static Random ran = new Random();
	
	UserManager um = UserManager.instance;
	FileManager fm = FileManager.instance;
	
	static int log;
	
	
	ATM(){
		log = -1;
		fm.loadData();
		
//		um.setDummy();
//		fm.saveData();
	}

	
	
	void mainMenu() {
		
		while(true) {
			um.printAllUser();
			System.out.println("[1]로그인");
			System.out.println("[2]회원가입");
			System.out.println("[0]종료 ");
			System.out.println("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			
			if(sel == 1) {
				login();
			}else if(sel == 2) {
				um.joinUser();
			}else if(sel== 0) {
				break;
			}
		}
	}

	void loginMenu() {
		
		while(true) {
			System.out.println("[1]계좌생성");
			System.out.println("[2]입금");
			System.out.println("[3]출금");
			System.out.println("[4]이체");
			System.out.println("[5]조회");
			System.out.println("[6]계좌삭제");
			System.out.println("[7]회원탈퇴");
			System.out.println("[0]로그아웃");
			System.out.println("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {um.createAcc();}
			else if(sel == 2) {um.deposit();}
			else if(sel == 3) {um.withdraw();}
			else if(sel == 4) {um.transfer();}
			else if(sel == 5) {um.showAccList();}
			else if(sel == 6) {um.removeAcc();}
			else if(sel == 7) {
				um.leaveUser();
				break;
			}else if(sel == 0) {
				log = -1;
				break;
			}
		}
	}
	
	
	
	
	
	void login() {
		System.out.println("[로그인] ID : ");
		String id = sc.next();
		
		System.out.println("[로그인] PW : ");
		String pw = sc.next();
		
		for (int i = 0; i < um.userList.length; i++) {
			if(id.equals(um.userList[i].id) && pw.equals(um.userList[i].pw)) {
				log = i;
			}
		}
		
		if(log == -1) {
			System.out.println("ID 또는 PW를 확인해주세요.");
			
		}else {
			System.out.println(id + "님 로그인");
			loginMenu();
		}
		
	}
	
}
