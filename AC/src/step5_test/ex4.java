package step5_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] id = {"qwer", "javaking", "abcd"};
		String[] pw = {"1111",   "2222", "3333"};
		String[] item = {"사과", "바나나", "딸기"};
		
		final int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		String fileName = "textEx2.txt";
		
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
					System.out.println("이미 로그인상태 입니다.");
					continue;
				}else {
					
					System.out.print("ID : ");
					String inId = scan.next();
					System.out.print("PW : ");
					String inPw = scan.next();
					
					
					for (int i = 0; i < id.length; i++) {
						if(pw[i].equals(inPw) && id[i].equals(inId)) {
							log = i;
						}
					}
					
					if(log == -1) {
						System.out.println("ID 또는 PW를 확인해 주세요.");
					}else {
						System.out.println(id[log]+"님 로그인 성공");
					}
					
				}
					
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("이미 로그아웃 상태 입니다.");
					continue;
				}
				System.out.println("로그아웃 되었습니다.");
				log = -1;
				
			}
			else if(sel == 3) {
				if(log == -1) {
					System.out.println("로그인 후 이용 가능합니다.");
					continue;
				}
				
				while(true) {
					System.out.println("[상품목록]");
					for (int i = 0; i < item.length; i++) {
						System.out.println("["+(i+1)+"]"+item[i]);
					}
					System.out.println("[0]뒤로");
					System.out.print("입력 : ");
					int sel2 = scan.nextInt();
					
					if(sel2 > 0) {						
						jang[cnt][0] = log;
						jang[cnt][1] = sel2-1;
						
						cnt ++;
					}
					if(sel2 == 0) {
						break;
					}
					
				}
			}
			else if(sel == 4) {
				for (int i = 0; i < cnt; i++) {
					if(log == jang[i][0]) {
						
						if(jang[i][1] == 0) {
							System.out.println("사과");
						}
						else if(jang[i][1] == 1) {
							System.out.println("바나나");
						}
						else if(jang[i][1] == 2) {
							System.out.println("딸기");
						}
					}
				}
			}
			else if(sel == 5) {
				FileWriter fw = null;
				String data ="";
				
				
				for (int i = 0; i < cnt; i++) {
					data += jang[i][0];
					data += ":";
					data += jang[i][1];
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
			}
			
			else if(sel == 6) {
				File file = new File(fileName);
				String data = "";
				
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
							String temp2[] = temp[i].split(":");
							
							jang[i][0] = Integer.parseInt(temp2[0]);
							jang[i][1] = Integer.parseInt(temp2[1]);
							
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
//17:00
//17:32
