package step4_19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileEx07 {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		
		int size = 5;
		int cnt = 0;
		int log = -1;
		
		String[] accs = new String[size];
		String[]  pws = new String[size];
		int[]  moneys = new int[size];
		
		String fileName = "atm.txt";
		
		while(true) {
			
//			for (int i = 0; i < size; i++) {
//				System.out.print(accs[i] +" ");
//				
//			}System.out.println("////" + cnt);
			
			if(log != -1 ) {
				System.out.println(accs[log] + "님 로그인중\n잔액 : " + moneys[log] );
			}
			System.out.println("[ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) { //가입
				if(log != -1 ) {
					System.out.println("이미 로그인 중");
					continue;
				}
				
				if(cnt == 5) {
					System.out.println("더 이상 회원가입이 불가능합니다.");
					continue;
				}
				
				System.out.print("ID : ");
				String newAcc = scan.next();
				
				int check = -1;
				for (int i = 0; i < size; i++) {
					if(newAcc.equals(accs[i])) {
						check = 1;
					}
				}
				if(check == 1) {
					System.out.println("ID가 중복됩니다.");
					continue;
				}
				
				System.out.print("PW : ");
				String newPw = scan.next();
				
				accs[cnt] = newAcc;
				pws[cnt] = newPw;
				moneys[cnt] = 10000;
				cnt ++;
				
			}
			else if(sel == 2) { //탈퇴
				if(log == -1) {
					System.out.println("로그인 후 이용해 주세요.");
					continue;
				}
				
				System.out.print("탈퇴 ? (1.예 / 2. 아니오)");
				int choice = scan.nextInt();
				
				if(choice == 1) {
					for (int i = log; i < cnt-1; i++) {
						accs[i] = accs[i+1];
						pws[i] = pws[i+1];
						moneys[i] = moneys[i+1];
					}
					System.out.println("탈퇴 성공");
					cnt --;
					log = -1;
				
				}
				
			}
			else if(sel == 3) { //로그인
				if(log != -1) {
					System.out.println("이미 로그인 중");
					continue;
				}
				System.out.print("ID : ");
				String inAcc = scan.next();
				System.out.print("PW : ");
				String inPw = scan.next();
				
				
				for (int i = 0; i < size; i++) {
					if(inAcc.equals(accs[i]) && inPw.equals(pws[i])) {
						System.out.println(accs[i] + "님 로그인 성공");
						log = i;
					}
				}
			
			}
			else if(sel == 4) { //로그아웃
				if(log == -1) {
					System.out.println("이미 로그아웃 상태입니다.");
					continue;
				}
				
				System.out.println("로그아웃 성공");
				log = -1;
			}
			else if(sel == 5) { //입금
			
				
				System.out.print("입금할 금액 : ");
				int money = scan.nextInt();
				
				System.out.println("입금완료");
				moneys[log] += money;
				
				
			}
			else if(sel == 6) { // 출금
				if(log == -1) {
					System.out.println("로그인을 해주세요");
					continue;
				}
				
				System.out.println("출금금액 : ");
				int money = scan.nextInt();
				
				System.out.println("출금완료");
				moneys[log] -= money;
				
			}
			else if(sel == 7) { //이체
				if(log == -1) {
					System.out.println("로그인을 해주세요");
					continue;
				}
				
				System.out.print("이체할 계좌번호 : ");
				String reAcc = scan.next();
				int check = -1;
				for (int i = 0; i < accs.length; i++) {
					if(reAcc.equals(accs[i])) {
						check = i;
					}
				}
				if(check == -1) {
					System.out.println("계좌번호를 확인해주세요.");
					continue;
				}
				
				System.out.print("이체금액 : ");
				int money = scan.nextInt();
				
				if(moneys[log] < money) {
					System.out.println("잔액이 부족합니다.");
					continue;
				}
				
				moneys[log] -= money;
				moneys[check] += money;
				System.out.println("이체 성공");
				
				
			}
			else if(sel == 8) { //잔액
				if(log == -1) {
					System.out.println("로그인을 해주세요");
					continue;
				}
				
				System.out.println(accs[log] +"님의 잔액 : " + moneys[log]);
			}
			else if(sel == 9) { //세이브
				if(cnt == 0) {
					System.out.println("null data");
					continue;
				}
				
				FileWriter fw = null;
				String data  = "";
				
				for (int i = 0; i < cnt; i++) {
					data += accs[i];
					data += "/";
					data += pws[i];
					data += "/";
					data += String.valueOf(moneys[i]);
					data += "\n";
				}
				data = data.substring(0, data.length()-1);
				
				
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("저장되었습니다.");
			}
			else if(sel == 10) { //로드
				String data = "";
				File file = new File(fileName);
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					try {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while(true) {
							String line = br.readLine();
							if(line == null) {
								break;
							}
							data += line;
							data += "\n";
						}
						data = data.substring(0, data.length()-1);
						
						String temp[] = data.split("\n");
						cnt = temp.length;
						
						for (int i = 0; i < cnt; i++) {
							String temp2 [] =temp[i].split("/");
							
							accs[i] = temp2[0];
							pws[i] = temp2[1];
							moneys[i] = Integer.parseInt(temp2[2]);
						}
						
//						for (int i = 0; i < 5; i++) {
//							System.out.println(accs[i] + "/" + pws[i] +"/" + moneys[i]);
//						}
						
						fr.close();
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			else if(sel == 0) {
				break;
			}
			
		}


	}

}
