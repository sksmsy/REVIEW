package step5_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] vector = null;
		int cnt = 0;
		
		String fileName = "testEx1.txt";
		
		while(true) {
			if(vector != null) {
				for (int i = 0; i < cnt; i++) {
					System.out.print(vector[i] + " ");
				}
				System.out.println();
			}
			
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
				}
				else if(cnt > 0) {
					
					int temp[] = vector;
					vector = new int[cnt+1];
					
					for (int i = 0; i < temp.length; i++) {
						vector[i] = temp[i];
					}
				}
				
				System.out.print("값 : ");
				int data = scan.nextInt();
				
				vector[cnt] = data;
				cnt ++;
			}
			else if(sel == 2) {
				if(cnt == 1) {
					System.out.print("삭제할 인덱스 : ");
					int del = scan.nextInt();
					
					if(del > cnt || del < 0) {
						System.out.println("해당 값은 삭제할 수 없습니다.");
						continue;
					}
					
					vector = null;
					
				}else if(cnt > 1) {
					System.out.print("삭제할 인덱스 : ");
					int del = scan.nextInt();
					
					if(del > cnt || del < 0) {
						System.out.println("해당 값은 삭제할 수 없습니다.");
						continue;
					}
					
					int temp[] = vector;
					vector = new int [cnt-1];
					
					int j = 0;
					for (int i = 0; i < temp.length; i++) {
						if(i != del) {
							vector[j] = temp[i];
							j++;
						}
					}
				}
				cnt--;
			}
			else if(sel == 3) {
				String data = "";
				
				data += cnt+"\n";
				for (int i = 0; i < vector.length; i++) {
					data += vector[i];
					data += "/";
				}
				data = data.substring(0, data.length()-1);
				
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
					
					System.out.println("저장되었습니다.");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			else if(sel == 4) {
				File file = new File(fileName);
				
				String data = "";
				
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					try {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						data = br.readLine();
						cnt = Integer.parseInt(data);
						
						data = br.readLine();
						String temp[] = data.split("/");
						
						vector = new int[cnt];
						
						for (int i = 0; i < cnt; i++) {
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
// 16:33 
// 16:56