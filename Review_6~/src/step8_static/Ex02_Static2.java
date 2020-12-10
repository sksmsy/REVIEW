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
		String temp[] = data.split("\n");
		
		for (int i = 0; i < temp.length; i++) {
			User user = new User();
			String temp2[] = temp[i].split("/");
			user.id = temp2[0];
			user.pw = temp2[1];
			user.name = temp2[2];
			userList.add(user);
		}
	}
	
	boolean checkId(String id) {
		for (int i = 0; i < userList.size();  i++) {
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
	
	void join(AccManager am) {
		System.out.print("가입 ID >> ");
		String id = sc.next();
		if(checkId(id)) {
			System.out.println("ID 중복");
		}else {
			System.out.print("가입 PW >> ");
			String pw = sc.next();
			
			System.out.print("name >> ");
			String name = sc.next();
			
			User u = new User();
			u.id = id;
			u.pw = pw;
			u.name = name;
			
			userList.add(u);
			am.openAccount(id);
			System.out.println("회원가입 완료");
		}
	}
}

class Account{
	String userId;
	String accountId;
	int money;
}

class AccManager{
	Scanner sc = new Scanner(System.in);
	Vector<Account> accList = new Vector<Account>();
	
	void dataSetting(String data) {
		String temp[] = data.split("\n");
		for (int i = 0; i < temp.length; i++) {
			Account ac = new Account();
			String temp2[] = temp[i].split("/");
			ac.userId = temp2[0];
			ac.accountId = temp2[1];
			ac.money = Integer.parseInt(temp2[2]);
			accList.add(ac);
		}
	}
	
	
	Vector<Account> getPersonalAccount(String id){
		Vector<Account> personalList = new Vector<Account>();
		for (int i = 0; i < accList.size(); i++) {
			if(accList.get(i).userId.equals(id)) {
				personalList.add(accList.get(i));
			}
		}
		return personalList;
	}
	
	void openAccount(String id) {
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
			
			if(i <3-1) {
				acId += "-";
			}
		}
		
		System.out.println(id + " : " + acId);
		Account ac = new Account();
		ac.accountId = acId;
		ac.userId = id;
		ac.money = 0;
		accList.add(ac);
	}
	
	
	void deposit(UserManager um) {
		System.out.print("입금ID >> ");
		String id = sc.next();
		System.out.print("PW >> ");
		String pw = sc.next();
		
		if(um.checkLogin(id, pw)) {
			System.out.print("계좌번호 >> ");
			Vector<Account> personalAccount = getPersonalAccount(id);
			
			for (int i = 0; i < personalAccount.size(); i++) {
				System.out.print("["+i+"]" + personalAccount.get(i).accountId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
			
			int sel = sc.nextInt();
			System.out.print("금액 >> ");
			int money = sc.nextInt();
			personalAccount.get(sel).money += money;
		}
	}
	
	void checkBalance(UserManager um) {
		System.out.print("ID >> ");
		String id = sc.next();
		System.out.print("PW >> ");
		String pw = sc.next();
		
		if(um.checkLogin(id, pw)){
			Vector<Account> personalAccount = getPersonalAccount(id);
			for (int i = 0; i < personalAccount.size(); i++) {
				System.out.print("["+i+"]" + personalAccount.get(i).accountId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
		}
	}
}

class Bank{
	AccManager am;
	UserManager um;
	Scanner sc = new Scanner(System.in);
	
	void bankSetting(AccManager am, UserManager um) {
		this.am = am;
		this.um = um;
	}
	
	void run() {
		
		while(true) {
			System.out.println("(1)회원가입  (2)입금 (3)조회 (4)계좌추가 (5)이체 (6)회원탈퇴 (7)계좌삭제 (0)종료");
			int sel = sc.nextInt();
			if(sel == 1) {
				um.join(am);				
			}
			else if(sel == 2) {
				am.deposit(um);
			}
			else if(sel == 3) {
				am.checkBalance(um);
			}
		
			else if(sel == 0) {
				System.out.println("종료");
				break;
			}
		}
	}
}


public class Ex02_Static2 {
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
		// 1) test01 김철수 는 계좌를 3개 가지고있다.
		// 2) test02 이영희 는 계좌를 2개 가지고있다.
		// 3) test03 신민수 는 계좌를 2개 가지고있다.
		// 4) test04 최상민 은 계좌를 1개 가지고있다. 
		
		UserManager um = new UserManager();
		um.dataSetting(userdata);
		AccManager am = new AccManager();
		am.dataSetting(accountdata);
		
		Bank bank = new Bank();
		bank.bankSetting(am, um);
		bank.run();
				
	}
}
