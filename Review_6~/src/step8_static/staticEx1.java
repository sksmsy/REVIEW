package step8_static;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class User{
	String id;
	String pw;
	String name;
}

class UserManager{
	Scanner sc = new Scanner(System.in);
	Vector<User> userList = new Vector<User>();
	
	void dataSetting(String data) {
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
	
	boolean checkId(String id) {
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				return true;
			}
		}
		return false;
	}
	
	boolean checkLogin(String id, String pw) {
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id) && pw.equals(userList.get(i).pw)) {
				return true;
			}
		}
		return false;
	}
	
	void join(AccountManager am) {
		System.out.println("ID : ");
		String id = sc.next();
		if(checkId(id)) {
			System.out.println("ID가 중복됩니다.");
		}else {
			System.out.println("PW : ");
			String pw = sc.next();
			System.out.println("name : ");
			String name = sc.next();
			User user = new User();
			user.id = id;
			user.pw = pw;
			user.name = pw;
			userList.add(user);
			am.openAccount(id);
			System.out.println("회원가입");
		}
	}

	void removeUser(){
		System.out.println("ID : ");
		String id = sc.next();
		
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				userList.remove(i);
			}
		}
		
		
		
		
	}
}

class Account{
	String userId;
	String accountId;
	int money;
}

class AccountManager{
	Scanner sc = new Scanner(System.in);
	Vector<Account> accountList = new Vector<Account>();
	
	void dataSetting(String data) {
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
	
	Vector<Account> getPersonalAccount(String id){
		Vector<Account> personalList = new Vector<Account>();
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).userId.equals(id)) {
				personalList.add(accountList.get(i));
			}
		}
		return personalList;
	}
	
	void openAccount(String id) {
		Random ran = new Random();
		String acId = "";
		for (int i = 0; i < 3; i++) {
			int r1 = ran.nextInt(10);
			acId += r1;
			int r2 = ran.nextInt(10);
			acId += r2;
			int r3 = ran.nextInt(10);
			acId += r3;
			int r4 = ran.nextInt(10);
			acId += r4;
			if(i<3-1) {
				acId += "-";
			}
		}
		
		System.out.println(id +" : " + acId);
		Account ac = new Account();
		ac.accountId = acId;
		ac.userId = id;
		ac.money = 0;
		accountList.add(ac);
	}
	
	void deposit(UserManager um) {
		System.out.println("[입금] ID : ");
		String id = sc.next();
		System.out.println("[입금] PW : ");
		String pw = sc.next();
		
		if(um.checkLogin(id, pw)) {
			System.out.println("[입금] 계좌번호 선택");
			Vector<Account> personalAccount = getPersonalAccount(id);
			for (int i = 0; i < personalAccount.size(); i++) {
				System.out.print("["+i+"]" + personalAccount.get(i).accountId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
			int sel = sc.nextInt();
			System.out.println("[입금] 금액 : ");
			int money =sc.nextInt();
			personalAccount.get(sel).money += money;
		}
	}
	
	int checkAcc(String acc) {
		int check = -1;
		for (int i = 0; i < accountList.size(); i++) {
			if(acc.equals(accountList.get(i).accountId)) {
				check = i;
			}
		}
		return check;
	}
	
	
	
	void checkBalance(UserManager um) {
		System.out.println("ID : ");
		String id = sc.next();
		System.out.println("PW : ");
		String pw = sc.next();
		if(um.checkLogin(id, pw)) {
			Vector<Account> personalAccount = getPersonalAccount(id);
			for (int i = 0; i < personalAccount.size(); i++) {
				System.out.print("["+i+"]" + personalAccount.get(i).accountId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
		}
	}
	
	void addAccount(UserManager um) {
		System.out.println("ID > ");
		String id = sc.next();
		System.out.println("PW >");
		String pw = sc.next();
				
		if(um.checkLogin(id, pw)) {
			openAccount(id);
		}
	}
	
	void removeAccount(UserManager um) {
		System.out.println("ID : ");
		String id = sc.next();
		System.out.println("PW : ");
		String pw = sc.next();
		
		if(um.checkLogin(id, pw)) {
			Vector<Account> personalAccount = getPersonalAccount(id);
			for (int i = 0; i < personalAccount.size(); i++) {
				System.out.println("["+i+"]" + personalAccount.get(i).accountId);
			}
			
			System.out.println("[삭제] >");
			int sel = sc.nextInt();
			
			accountList.remove(sel);
			
			
		}
		
	}
	
	void sendMoney(UserManager um) {
		System.out.println("[송금] ID : ");
		String id = sc.next();
		System.out.println("[송금] PW : ");
		String pw = sc.next();
		
		if(um.checkId(id)) {
			System.out.print("[송금] 송금할 계좌번호 > ");
			String acc = sc.next();
			
			int check = checkAcc(acc);
			if(check > -1) {
				System.out.print("[송금] 금액 >");
				int money = sc.nextInt();
				
				accountList.get(check).money += money;
				
			}else {
				System.out.println("해당 계좌번호는 존재하지 않습니다");
			}
			
			
		}else {
			System.out.println("ID 또는 PW를 확인해주세요");
		}
	}
	
}

class Bank{
	AccountManager am;
	UserManager um;
	Scanner sc = new Scanner(System.in);
	void bankSetting(AccountManager am, UserManager um) {
		this.am = am;
		this.um = um;
	}
	
	void run() {
		
		while(true) {
			System.out.println("(1)회원가입  (2)입금 (3)조회 (4)계좌추가 \n(5)이체 (6)회원탈퇴 (7)계좌삭제 (0)종료");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				um.join(am);
			}
			else if(sel == 2) {
				am.deposit(um);
			}
			else if(sel ==3) {
				am.checkBalance(um);
			}
			else if(sel == 4) {
				am.addAccount(um);
			}
			else if(sel == 5) {
				am.sendMoney(um);
			}
			else if(sel == 6) {
				um.removeUser();
			}
			else if(sel == 7) {
				am.removeAccount(um);
				
			}
			else if(sel == 0) {
				break;
			}
		}
	}
}



public class staticEx1 {
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
		
		
		UserManager um = new UserManager();
		um.dataSetting(userdata);
		
		AccountManager am = new AccountManager();
		am.dataSetting(accountdata);
		
		Bank bank = new Bank();
		bank.bankSetting(am, um);
		bank.run();
	}
}
