package static1;

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
	Vector<User> userList = new Vector<>();
	
	
	public void dataSetting(String data) {
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
	
	public boolean checkId(String id) {
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkLogin(String id, String pw) {
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id) && pw.equals(userList.get(i).pw)) {
				return true;
			}
		}
		return false;
	}
	
	public void join(AccountManager am) {
		
		System.out.println("가입 // ID >> ");
		String id = sc.next();
		
		if(checkId(id)) {
			System.out.println("ID 중복");
		}else {
			System.out.println("가입 // PW >> ");
			String pw = sc.next();
			
			System.out.println("가입 // 이름 >> ");
			String name = sc.next();
			
			User u = new User();
			
			u.id = id;
			u.pw = pw;
			u.name = name;
			
			userList.add(u);
			am.openAcc(id);
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
	
	Scanner sc = new Scanner(System.in);
	Vector<Account> accountList = new Vector<Account>();
	
	void dataSetting(String data) {
		String temp[] = data.split("\n");
		for (int i = 0; i < temp.length; i++) {
			String temp2[] = temp[i].split("/");
			
			Account acc = new Account();
			
			acc.userId = temp2[0];
			acc.accId = temp2[1];
			acc.money = Integer.parseInt(temp2[2]);
			
			accountList.add(acc);
		}
	}
	
	Vector<Account> getPersonalAcc(String id){
		Vector<Account> personalList = new Vector<>();
		
		for (int i = 0; i < accountList.size(); i++) {
			if(id.equals(accountList.get(i).userId)) {
				personalList.add(accountList.get(i));
			}
		}
		return personalList;
	}
	
	void openAcc(String id) {
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
		
		System.out.println(id + " : " + acId);
		Account ac = new Account();
		ac.accId = acId;
		ac.userId = id;
		ac.money = 0;
		accountList.add(ac);
	}
	
	void deposit(UserManager um) {
		System.out.println("입금 // ID >> ");
		String id = sc.next();
		System.out.println("입금 // PW >> ");
		String pw = sc.next();
		
		if(um.checkLogin(id, pw)) {
			System.out.println("입금할 계좌 선택 > ");
			Vector<Account> personalAccount = getPersonalAcc(id);
			for (int i = 0; i < personalAccount.size(); i++) {
				System.out.print("[" + i + "]" + personalAccount.get(i).accId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
			int sel = sc.nextInt();
			
			System.out.println("입금할 금액 > ");
			int money = sc.nextInt();
			
			personalAccount.get(sel).money += money;
			System.out.println("입금 완료");
		}
		
	}
	
	void checkBalance(UserManager um) {
		System.out.println("입금 // ID >> ");
		String id = sc.next();
		System.out.println("입금 // PW >> ");
		String pw = sc.next();
		
		if(um.checkLogin(id, pw)) {
			Vector<Account> personalAccount = getPersonalAcc(id);
			for (int i = 0; i < personalAccount.size(); i++) {
				System.out.print("[" + i + "]" + personalAccount.get(i).accId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
		}
	}
	
	void print() {
		for (int i = 0; i < accountList.size(); i++) {
			System.out.println(accountList.get(i).money);
		}
	}
}

class Bank{
	
	AccountManager am;
	UserManager um;
	Scanner sc = new Scanner(System.in);
	
	void bankSetting(AccountManager am , UserManager um) {
		this.am = am;
		this.um = um;
	}
	
	void run() {
		
		while(true) {
			System.out.println("1.회원가입 2.입금 3.조회 4.계좌추가");
			System.out.println("0.종료");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				um.join(am);
			}
			else if(sel == 2) {
				am.deposit(um);
			}
			else if(sel == 3) {
				am.checkBalance(um);
			}else if(sel == 0) {
				 break;
			}else if(sel == 9) {
				am.print();
			}
		}
	}
}

public class static_Ex01 {
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
		AccountManager am = new AccountManager();
		am.dataSetting(accountdata);
		
		Bank bank = new Bank();
		bank.bankSetting(am, um);
		bank.run();
	}
}
