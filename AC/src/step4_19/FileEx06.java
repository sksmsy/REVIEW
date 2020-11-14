package step4_19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileEx06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] vector = null;
		int cnt = 0;
		
		String fileName = "vector.txt";
		

		while(true) {
			if(vector != null) {
				for (int i = 0; i < cnt; i++) {
					System.out.print(vector[i] + " ");
				}
			}System.out.println();
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(cnt == 0) {
					vector = new int[cnt+1];
	
				}else if(cnt > 0) {
					int temp [] = vector;
					vector = new int [cnt+1];
					
					for (int i = 0; i < cnt; i++) {
						vector[i] = temp[i];
					}
					temp =null;
				}
				System.out.print("data : ");
				int data = scan.nextInt();
				
				vector[cnt] = data;
				cnt ++;
			}
			
			else if(sel == 2) {
				System.out.print("인덱스 입력 : ");
				int delIdx = scan.nextInt();
				
				if(delIdx > cnt || delIdx < 0) {
					System.out.println("해당 값은 삭제할 수 없습니다.");
					continue;
				}
				
				if(cnt == 1) {					
					vector = null;
				
				}else if(cnt > 1) {
		
					int temp [] = vector;
					vector = new int[cnt-1];
					
					for (int i = 0; i < delIdx; i++) {
						vector[i] = temp[i];
					}
					for (int i = delIdx; i < cnt-1; i++) {
						vector[i] = temp[i+1];
					}
					temp = null;
				}
				cnt --;
			}
			else if(sel == 3) {
				if(vector == null) {
					System.out.println("null data");
					continue;
				}
				
				String data ="";
				
				try {
					
					
					for (int i = 0; i < cnt; i++) {
						data += String.valueOf(vector[i]);
						data += "\n";
					}
					data = data.substring(0, data.length()-1);
					
					FileWriter fw = null;
					
					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else if(sel == 4) {
				File file = new File(fileName);
				
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						String data = "";
						
						while(true) {
							String line = br.readLine();
							if(line == null) {
								break;
							}
							data += line;
							data += "\n";
						}
						data = data.substring(0, data.length()-1);

						
						String temp [] = data.split("\n");
						cnt = temp.length;
						
						vector = new int[cnt];
						
						for (int i = 0; i < temp.length; i++) {
							vector[i] = Integer.parseInt(temp[i]);
						}
						
						fr.close();
						br.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			else if(sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}


	}

}
