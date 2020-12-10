package static2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class User{
	String id;
	String pw;
	String name;
	
}

class UserManager{
	static Scanner sc = new Scanner(System.in);
	static Vector<User> userList = new Vector<User>();
	
	static void dataSetting(String data) {
		
		String temp[] = data.split("\n");
		for (int i = 0; i < temp.length; i++) {
			String temp2[] = temp[i].split("/");
			User u = new User();
			
			u.id = temp2[0];
			u.pw = temp2[1];
			u.name = temp2[2];
			
			userList.add(u);
		}
	}
	
	static boolean checkId(String id) {
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkLogin(String id, String pw) {
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id) && pw.equals(userList.get(i).pw)) {
				return true;
			}
		}
		return false;
	}
	
	static void join() {
		System.out.println("가입 // ID >> ");
		String id = sc.next();
		
		if(checkId(id)) {
			System.out.println("ID가 중복됩니다.");
		}else {
			System.out.println("가입 // PW >> ");
			String pw = sc.next();
			
			System.out.println("가입 // NAME >> ");
			String name = sc.next();
			
			User u = new User();
			u.id = id;
			u.pw = pw;
			u.name = name;
			
			userList.add(u);
			AccountManager.openAcc(id);
			System.out.println("회원가입 완료");
		}
	}
}

class Account{
	String userId;
	String accId;
	int money;
}

class AccountManager{
	static Scanner sc = new Scanner(System.in);
	static Vector<Account> accList = new Vector<Account>();
	
	
	static void dataSetting(String data) {
		String temp[] = data.split("\n");
		for (int i = 0; i < temp.length; i++) {
			String temp2[] = temp[i].split("/");
			
			Account ac = new Account();
			
			ac.userId = temp2[0];
			ac.accId = temp2[1];
			ac.money = Integer.parseInt(temp2[2]);
			
			accList.add(ac);
		}
	}
	static void openAcc(String id) {
		Random ran = new Random();
		String acId ="";
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				int r = ran.nextInt(10);
				acId += r;
			}
			if(i < 3-1) {
				acId += "-";
			}
		}
		
		System.out.println("계좌생성 // "+id+ " : "+acId);
		Account ac = new Account();
		ac.accId = acId;
		ac.userId = id;
		ac.money = 0;
		accList.add(ac);
	}
	
	
	static Vector<Account> getPersonalAcc(String id){
		Vector<Account> personalList = new Vector<Account>();
		for (int i = 0; i < accList.size(); i++) {
			if(id.equals(accList.get(i).userId)) {
				personalList.add(accList.get(i));
			}
		}
		return personalList;
	}

	static void deposit() {
		System.out.println("입금 // ID >> ");
		String id = sc.next();
		System.out.println("입금 // PW >> ");
		String pw = sc.next();
		
		if(UserManager.checkLogin(id, pw)) {
			System.out.println("계좌 번호 선택 > ");
			Vector<Account> personalList = getPersonalAcc(id);
			for (int i = 0; i < personalList.size(); i++) {
				System.out.print("[" + i + "]" + personalList.get(i).accId + " : ");
				System.out.println(personalList.get(i).money);
			}
			int sel = sc.nextInt();
			System.out.println("입금할 금액 > ");
			int money = sc.nextInt();
			
			personalList.get(sel).money += money;
			
			System.out.println(money + "원 입금 완료");
		}
	}
	
	
	static void checkBalance() {
		System.out.println("조회 // ID >> ");
		String id = sc.next();
		System.out.println("조회 // PW >> ");
		String pw = sc.next();
		
		if(UserManager.checkLogin(id, pw)) {
			Vector<Account> personalList = getPersonalAcc(id);
			for (int i = 0; i < personalList.size(); i++) {
				System.out.print("[" + i + "]" + personalList.get(i).accId + " : ");
				System.out.println(personalList.get(i).money);
			}
		}
	}
	
}

public class static_Ex02 {

}
