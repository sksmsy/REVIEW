package step8_static2;

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
	static Vector<User> userList = new  Vector<User>();
	
	static void dataSetting(String data) {
		String token[] = data.split("\n");
		for (int i = 0; i < token.length; i++) {
			User user = new User();
			String token2[] = token[i].split("/");
			
			user.id = token2[0];
			user.pw = token2[1];
			user.name = token2[2];
			userList.add(user);
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
		System.out.print("ID > ");
		String id = sc.next();
		if(checkId(id)) {
			System.out.println("ID 중복");
		}
		else {
			System.out.print("PW > ");
			String pw = sc.next();
			System.out.print("name > ");
			String name = sc.next();
			
			User user = new User();
			
			user.id = id;
			user.pw = pw;
			user.name = name;
			
			
			userList.add(user);
		}
	}
}


class Account{
	String userId;
	String accountId;
	int money;
}


class AccountManager{
	static Scanner sc = new Scanner(System.in);
	static Vector<Account> accountList = new Vector<Account>();
	
	static void dataSetting(String data) {
		String token[] = data.split("\n");
		for (int i = 0; i < token.length; i++) {
			Account ac = new Account();
			String token2[] = token[i].split("/");
			
			ac.userId = token2[0];
			ac.accountId = token2[1];
			ac.money = Integer.parseInt(token2[2]);
			accountList.add(ac);
		}
	}

	
	static void openAccount(String id) {
		Random ran = new Random();
		String acId ="";
		for (int i = 0; i < 3; i++) {
			int r1 = ran.nextInt(10);
			acId += r1;
			int r2 = ran.nextInt(10);
			acId += r2;
			int r3 = ran.nextInt(10);
			acId += r3;
			int r4 = ran.nextInt(10);
			acId += r4;
			if(i < 3 - 1) {
				acId += "-";
			}
		}
		
		System.out.println("[계좌생성]" + id + " : " + acId);
		Account ac = new Account();
		ac.accountId = acId;
		ac.userId = id;
		ac.money = 0;
		accountList.add(ac);
	}
	
	static Vector<Account> getPersonalAccount(String id){
		Vector<Account> personalList = new Vector<Account>();
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).userId.equals(id)) {
				personalList.add(accountList.get(i));
			}
		}
		return personalList;
	}
	
	
	static void deposit() {
		System.out.print("ID > ");
		String id = sc.next();
		System.out.print("PW > ");
		String pw = sc.next();
		if(UserManager.checkLogin(id, pw)) {
			System.out.println("계좌번호 > ");
			Vector<Account> personalAccount = getPersonalAccount(id);
			for (int i = 0; i < personalAccount.size(); i++) {
				System.out.print("[" + i+"]" + personalAccount.get(i).accountId +" : ");
				System.out.println(personalAccount.get(i).money);
			}
			
			int sel = sc.nextInt();
			System.out.println("금액 > ");
			int money = sc.nextInt();
			personalAccount.get(sel).money += money;
		}
	}
	static void checkBalance() {
		System.out.println("ID > ");
		String id = sc.next();
		System.out.println("PW > ");
		String pw = sc.next();
		if(UserManager.checkLogin(id, pw)) {			
			Vector<Account> personalAccount = getPersonalAccount(id);
			for(int i = 0; i < personalAccount.size(); i++) {
				System.out.print("[" + i + "] " + personalAccount.get(i).accountId + " : ");
				System.out.println(personalAccount.get(i).money);
			}			
		}
	}
	
	
	static void addAcc() {
		System.out.print("ID > ");
		String id = sc.next();
		System.out.print("PW > ");
		String pw = sc.next();
		if(UserManager.checkLogin(id, pw)) {
			openAccount(id);
		}
	}
}

class Bank{
	Scanner sc = new Scanner(System.in);
	
	
	void run() {
		while(true) {
			System.out.println("(1)회원가입  (2)입금 (3)조회 (4)계좌추가 (0)종료");
			int sel = sc.nextInt();
			if(sel == 1) {
				UserManager.join();						
			}
			else if(sel == 2) {
				AccountManager.deposit();				
			}
			else if(sel == 3) {
				AccountManager.checkBalance();				
			}
			else if(sel == 4) {
				AccountManager.addAcc();
			}
			else if(sel == 0) {
				System.out.println("종료");
				break;
			}
		}
	}
}

public class staticEx2 {
	public static void main(String[] args) {
		String userdata = "test01/pw1/김철수\n";
		userdata += "test02/pw2/이영희\n";
		userdata += "test03/pw3/신민수\n";
		userdata += "test04/pw4/최상민";
		
		String accountdata = "test01/1111-1111-1111/8000\n";
		accountdata += "test02/2222-2222-2222/5000\n";
		accountdata += "test01/3333-3333-3333/11000\n";
		accountdata += "test03/4444-4444-4444/9000\n";
		accountdata += "test01/5555-5555-5555/5400\n";
		accountdata += "test02/6666-6666-6666/1000\n";
		accountdata += "test03/7777-7777-7777/1000\n";
		accountdata += "test04/8888-8888-8888/1000";
		
		UserManager.dataSetting(userdata);
		AccountManager.dataSetting(accountdata);
		Bank bank = new Bank();
		bank.run();
	}
}
