package step6_3_method2;

import java.util.Scanner;

class Atma{

	Scanner sc = new Scanner(System.in);
	
	String name = "";
	
	String[] arAcc = {"1111", "2222", "3333", "", ""};
	String[] arPw  = {"1234", "2345", "3456", "", ""};
	int[] arMoney  = {87000, 34000, 17500, 0, 0};
	
	int cnt = 3;
	
	int log = 2;
	
	void showMember() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(arAcc[i] +":"+arPw[i]+":"+arMoney[i]);
		}
	}
	
	void showMenu() {  
		System.out.print("# 로그인 상태 : ");
		if(log == -1) {
			System.out.println("로그아웃");
		}else {
			System.out.println(arAcc[log]+"님 로그인");
		}
		
		System.out.println("=== " + name + " ===");
		System.out.println("1.회원가입");	
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.입금하기");
		System.out.println("6.이체하기");
	}
	
	int checkAcc(String myAcc) {
		
		int check = 1;
		for (int i = 0; i < cnt; i++) {
			if(arAcc[i].equals(myAcc)) {
				check = -1;
			}
		}
		return check;
	}
	
	int checkPw(int accCheck) {
		System.out.print("Pw : ");
		String myPw = sc.next();
		
		int pwCheck = -1;
		
		if(arPw[accCheck].equals(myPw)) {
			pwCheck = 1;
		}
		return pwCheck ;
				
	}
	
	
	int checkAcc() {
		
		System.out.print("탈퇴 계좌번호 : ");
		String myAcc = sc.next();
		
		int accCheck = -1;
		for (int i = 0; i < cnt; i++) {
			if(arAcc[i].equals(myAcc)) {
				accCheck = i;
			}
		}
		return accCheck;
	}
	
	void delMember() {
		
		if(cnt == 0) {
			System.out.println("탈퇴할 회원정보가 없습니다.");
			return;
		}
		
		int accCheck = checkAcc();
		
		if(accCheck != -1) {
			int pwCheck = checkPw(accCheck);
			if(pwCheck == -1) {
				System.out.println("비밀번호 틀림");
			}else {
				for (int i = accCheck; i < cnt-1; i++) {
					arAcc[i] = arAcc[i+1];
					arPw[i] = arPw[i+1];
					arMoney[i]=arMoney[i+1];
				}
				cnt -=1;
				System.out.println("탈퇴완료");
			}
		}else {
			System.out.println("없는 계좌번호");
		}
	}
	
	void joinMember() {
		
		if(cnt == 5) {
			System.out.println("더이상 가입할 수 없습니다.");
			return;
		}
		
		System.out.print("ID : ");
		String myAcc = sc.next();
		int check = checkAcc(myAcc);
		
		if(check == -1) {
			System.out.println("계좌번호 중복");
			
		}else {
			System.out.print("PW : ");
			String myPw = sc.next();
			
			arAcc[cnt] = myAcc;
			arPw[cnt] = myPw;
			arMoney[cnt ] = 1000;
			
			cnt += 1;
			System.out.println("회원가입 완료.");
			
		}
	}
	
	
	void login() {
		if(log != -1) {
			System.out.println("이미 로그인중");
			return;
		}
		System.out.print("ID : ");
		String myId =sc.next();
		System.out.print("PW : ");
		String myPw = sc.next();
		
		for (int i = 0; i < cnt; i++) {
			if(myId.equals(arAcc[i]) && myPw.equals(arPw[i])) {
				log = i;
			}
		}
		
		if(log == -1) {
			System.out.println("ID또는 PW를 확인해 주세요");
		}else {
			System.out.println("로그인성공");
		}
	}
	
	void logout () {
		if(log == -1) {
			System.out.println("로그아웃 상태");
		}else {
			log = -1;
			System.out.println("로그아웃 완료");
		}
	}
	
	void income() {
		System.out.print("입금금액 : ");
		int money = sc.nextInt();
		
		arMoney[log] += money;
		System.out.println("입금완료");
	}

	
	void trans() {
		System.out.print("이체할 계좌번호 : ");
		String transAcc = sc.next();
		
		
		int check = -1;
		for (int i = 0; i < arAcc.length; i++) {
			if(arAcc[i].equals(transAcc)) {
				check = i;
			}
		}
		
		if(check == -1) {
			System.out.print("계좌번호를 확인해주세요");
		}else {
			System.out.print("이체할 금액 : ");
			int transMoney = sc.nextInt();
			
			if(arMoney[log] >= transMoney) {
				arMoney[log] -= transMoney;
				arMoney[check] += transMoney;
				System.out.println("이체완료");
				
			}else {
				System.out.println("잔액부족");
			}
		}
	}
	
	
	void run() {
		
		while(true) {
			showMember();
			
			showMenu();
			
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			
			if(choice == 1) { joinMember();}
			else if(choice == 2) {delMember();}
			else if(choice == 3) { login(); }
			else if(choice == 4) { logout();}
			else if(choice == 5) { income();}
			else if(choice == 6) { trans();}
			
		}
	}
}


public class Ex25A {

	public static void main(String[] args) {

	}

}
