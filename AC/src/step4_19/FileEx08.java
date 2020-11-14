package step4_19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileEx08 {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"사과", "바나나", "딸기"};
		
		final int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		String fileName = "jang.txt";
		
		int cnt = 0;
		int log = -1;
		
		while(true) {
			
			System.out.println("[SHOP]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(log != -1) {
					System.out.println("이미 로그인 중");
					continue;
				}
				System.out.print("ID : ");
				String inAcc = scan.next();
				System.out.print("PW : ");
				String inPw = scan.next();
				
				int check = -1;
				for (int i = 0; i < ids.length; i++) {
					if(inAcc.equals(ids[i]) && inPw.equals(pws[i])) {
						System.out.println(ids[i] + "님 로그인 성공");
						log = i;
						check = 0;
					}
				}
				if(check == -1) {
						System.out.println("ID또는PW를 확인해주세요");
					
				}
			
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("이미 로그아웃 상태입니다.");
					continue;
				}
				System.out.println("로그아웃 성공");
				log = -1;
			}
			else if(sel == 3) {
				if(log == -1 ) {
					System.out.println("로그인 해주세요.");
					continue;
				}
				while(true) {
					
					System.out.println("[목록]");
					for (int i = 0; i < items.length; i++) {
						System.out.println("["+(i+1)+"]" + items[i]);
					}
					System.out.println("[0]뒤로");
					
					System.out.print("입력 : ");
					int sel2 = scan.nextInt();
					
					
					if(sel2 == 0) {
						break;
					}
					jang[cnt][0] = log;
					jang[cnt][1] = sel2;
					
					cnt ++;
				}
			}
			else if(sel == 4) {
				int ap = 0;
				int ba = 0;
				int st = 0;
				
				for (int i = 0; i < cnt; i++) {
					if(jang[i][0] == log) {
						if(jang[i][1] == 1) {ap +=1;}
						else if(jang[i][1] == 2) {ba +=1;}
						else if(jang[i][1] == 3) {st +=1;}
						
					}
				}
				System.out.println(items[0] + " : " + ap + "개");
				System.out.println(items[1] + " : " + ba + "개");
				System.out.println(items[2] + " : " + st + "개");
			}
			else if(sel == 5) {
				
				String data = "";
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(fileName);
					
					for(int i = 0; i <cnt; i++) {
						data += jang[i][0];
						data += ":";
						data += jang[i][1];
						data += "\n";
					}
					data = data.substring(0, data.length()-1);
					
					fw.write(data);
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else if(sel == 6) {
				String data = "";
				File file = new File (fileName);
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
						
						String temp[] = data.split("\n");
						cnt = temp.length;
						
						for (int i = 0; i < cnt; i++) {
							String info [] = temp[i].split(":");
							
							jang[i][0] = Integer.parseInt(info[0]);
							jang[i][1] = Integer.parseInt(info[1]);
						} 
						
						
						fr.close();
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}


	}

}
