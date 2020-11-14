package allRe;

import java.util.Scanner;
/*
 * # ATM[4단계] : 전체 기능구현
 * 1. 회원가입
 * . id와 pw를 입력받아 가입
 * . 가입 시 돈 1000원 부여
 * . id 중복체크
 * 2. 회원탈퇴
 * . 로그인시에만 이용가능
 * 3. 로그인
 * . id와 pw를 입력받아 로그인
 * . 로그아웃 상태에서만 이용가능
 * 4. 로그아웃
 * . 로그인시에만 이용가능
 * 5. 입금
 * . 로그인시에만 이용가능
 * 6. 이체
 * . 로그인시에만 이용가능
 * 7. 잔액조회
 * . 로그인시에만 이용가능
 */


public class ArrayEx32 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
		
		int MAX = 5;
		
		int[] arId = new int[MAX];
		int[] arPw = new int[MAX];
		int[] arMoney = new int[MAX];
		
		int cnt = 0;
		int log = -1;
		
		String menu = "=== ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
		
		while(true) {
			System.out.println("회원 목록");
			for (int i = 0; i < arMoney.length; i++) {
				System.out.print(arId[i] + " ");
			}System.out.println();
			
			if(log != -1) {
				System.out.println("현재 접속자 : " + arId[log] + ", 금액 : " + arMoney[log]);
			}System.out.println();
			
			System.out.println(menu);
			
			int sel = scan.nextInt();
			
			
			if(sel == 1) { //회원가입
				if(cnt == 5) {
					System.out.println("더 이상 가입할 수 없습니다.");
					continue;
				}
				
				if(log == -1) {
					System.out.print("ID : ");
					int newId = scan.nextInt();
					
					for (int i = 0; i < arId.length; i++) {
						if(newId == arId[i]) {
							System.out.println("ID가 중복됩니다. ");
							continue;
						}
					}
					
					System.out.print("PW : ");
					int newPw = scan.nextInt();
					
					arId[cnt] = newId;
					arPw[cnt] = newPw;
					arMoney[cnt] = 1000;
					
					cnt ++;
					
				}else {
					System.out.println("로그인 되어 있습니다.");
				}
				
			}
			else if(sel == 2) { // 탈퇴
				
				if(log == -1) {
					System.out.println("로그인을 먼저 해주세요.");
					continue;
				}else {
					
					arId[log] = 0;
					arPw[log] = 0;
					arMoney[log] = 0;
					for (int i = log; i < arId.length-1; i++) {
						arId[i] = arId[i + 1];
						arPw[i] = arId[i + 1];
						arMoney[i] = arMoney[i + 1];
						
					}
					
					log = -1;
					cnt--;
					System.out.println("회원탈퇴가 완료되었습니다.");
					
				}
				
			}
			else if(sel == 3) { //로그인
				if(log != -1) {
					System.out.println("이미 로그인되어있습니다.");
					continue;
				}
				
				System.out.print("ID : ");
				int inId = scan.nextInt();
				
				System.out.print("PW : ");
				int inPw = scan.nextInt();
				
				int check = -1;
				for (int i = 0; i < arMoney.length; i++) {
					if(inId == arId[i] && inPw == arPw[i]) {
						check = i;
					}
				}
				
				if(check == -1) {
					System.out.println("ID 또는 PW를 확인해주세요.");
				
				}else {
					log = check;
					System.out.println(arId[check] + "님 로그인 성공");
				}
				
				
				
			}
			else if(sel == 4) { //로그아웃
				if(log == -1) {
					System.out.println("이미 로그아웃 상태입니다.");
					continue;
				}
				System.out.println(arId[log] + "님 로그아웃 완료.");
				log = -1;
				
			}
			else if(sel == 5) { // 입
				if(log == -1) {
					System.out.println("먼저 로그인을 해주세요.");
					continue;
				}
				
				System.out.print("입금할 금액 : ");
				int inMoney = scan.nextInt();
				
				arMoney[log] += inMoney;
				
				System.out.println("정상적으로 처리되었습니다.");
				
			}
			else if(sel == 6) {  // 이체
				if(log == -1) {
					System.out.println("먼저 로그인을 해주세요.");
					continue;
				}
				
				System.out.print("입금할 계좌 : ");
				int sendId = scan.nextInt();
				
				int check = -1;
				for (int i = 0; i < arMoney.length; i++) {
					if(sendId == arId[i]) {
						check = i;
					}
				}
				
				if(check == -1) {
					System.out.println("해당 계좌가 존재하지 않습니다.");
				
				}else {
					System.out.print("이체 금액 : ");
					int sendMoney = scan.nextInt();
					
					if(arMoney[log] < sendMoney) {
						System.out.println("계좌 잔액이 부족합니다.");
						continue;
					}
					
					
					arMoney[log] -= sendMoney;
					arMoney[check] += sendMoney;
					
					System.out.println("정상적으로 처리되었습니다.");
				}
			}
			
			
			else if(sel == 7) {
				if(log == -1) {
					System.out.println("먼저 로그인을 해주세요.");
					continue;
				}
				
				System.out.println(arMoney[log]+"원");
				
			}
			else if(sel == 0) {
				break;
			}
		}



	}

}
