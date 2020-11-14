package step6_3_method2;

import java.util.Scanner;

class Atm{
	
	Scanner sc = new Scanner(System.in);
	
	String name = "";
	
	String id [] = {"1111","2222","3333","",""};
	String pw [] = {"1234","2345","3456","",""};
	int money[] = {87000,34000,17000,0,0};
	
	int cnt = 3;
	int log = 2;
	
	void member() {
		
		for (int i = 0; i < 5; i++) {
			System.out.println(id[i]+"/"+pw[i]+"/"+money[i]);
		}
		if(log == -1 ) {
			System.out.println("로그인 해주세요");
		}else {
			System.out.println(id[log] + "님 로그인중 ");
			System.out.println("잔액 : " + money[log]);
		}
	}
	
	void menu() {
		System.out.println(name);
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.입금");
		System.out.println("6.이체");
	}
	
	void join() {
		if(log == -1) {
			System.out.println("Id : ");
			String newId = sc.next();
			
			int check = -1;
			for (int i = 0; i < id.length; i++) {
				if(newId.equals(id[i])){
					check = -1;
				}else {
					check = 1;
				}
			}
			
			if(check == 1) {
				System.out.print("PW : ");
				String newPw = sc.next();
				
				id[cnt] = newId;
				pw[cnt] = newPw;
				money[cnt] += 10000;
				cnt ++;
				
				
			}else { 
				System.out.println("ID가 중복됩니다.");
			}
			
		}else if(log > -1 || cnt > 4) {
			System.out.println("이미 로그인 상태이거나 더이상 가입할 수 없습니다.");
			return;
		}
	}
	
	void del() {
		if(log == -1) {
			System.out.println("로그인 해주세요");
			
		}else {
			System.out.print("PW : ");
			String del = sc.next();
			
			int check = -1;
			for (int i = 0; i < pw.length; i++) {
				if(del.equals(pw[i])) {
					check = i;
				}
			}
			
			if(check == -1) {
				System.out.println("pw가 일치하지 않습니다.");
				
			}else {
				for (int i = check; i < cnt-1; i++) {
					id[i] = id[i+1];
					pw[i] = pw[i+1];
					money[i] = money[i+1];
				}
				
				cnt --;
				log = -1;
				
				System.out.println("탈퇴완료");
			}
		}
	}
	void logIn() {
		if(log > -1) {
			System.out.println("로그인상태입니다.");
		}else {
			System.out.print("ID : ");
			String inId = sc.next();
			System.out.print("PW : ");
			String inPw = sc.next();
			
			int check = -1;
			for (int i = 0; i < id.length; i++) {
				if(inId.equals(id[i]) && inPw.equals(pw[i])) {
					check = i;
				}
			}
			
			if(check == -1) {
				System.out.println("ID또는 PW를 확인해주세요");
			}else {
				log = check;
				System.out.println(id[check]+"님 로그인");
			}
		}
	}
	
	void logOut() {
		if(log == -1) {
			System.out.println("이미 로그아웃 상태입니다.");
		}else {
			log = -1;
			
			System.out.println("로그아웃 완료");
		}
	}
	
	
	void inMoney() {
		if(log == -1) {
			System.out.println("로그인 해주세요");
		}else {
			System.out.print("입금할 금액 : ");
			int inMo = sc.nextInt();
			
			money[log] += inMo;
			System.out.println("입금완료");
		}
	}
	
	void transfer() {
		if(log == -1) {
			System.out.println("로그인 해주세요");
		}else {
			System.out.print("이체할 계좌번호 : ");
			String trId = sc.next();
		
			int check = -1;
			for (int i = 0; i < id.length; i++) {
				if(trId.equals(id[i])) {
					check = i;
				}
			}
			
			if(check == -1) {
				System.out.println("계좌번호를 확인해주세요");
			}else {
				System.out.println("이체 금액 : " );
				int trMo = sc.nextInt();
				
				if(trMo > money[log]) {
					System.out.println("잔액이 부족합니다.");
				}else {
					
					money[check] += trMo;
					System.out.println("이체 완료");
				}
				
			}
		}
	}
	
	void run() {
		while(true) {
			
			member();
			menu();
			
			
			System.out.print("메뉴선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) { join(); }
			else if(sel == 2) { del();}
			else if(sel == 3) { logIn();}
			else if(sel == 4) { logOut();}
			else if(sel == 5) { inMoney();}
			else if(sel == 6) { transfer();}
			
		}
	}
	
}


public class Ex25 {

	public static void main(String[] args) {
		
		Atm atm = new Atm();
		
		atm.name = "abcd";
		
		atm.run();
	}

}
