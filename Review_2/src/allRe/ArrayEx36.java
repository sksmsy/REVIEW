package allRe;

import java.util.Scanner;

public class ArrayEx36 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int[] scr = null;
		int cnt = 0;
		
		while(true) {
		
			if(scr != null) {
				for (int i = 0; i <cnt; i++) {
					System.out.print(scr[i] + " ");
				}System.out.println();
			}
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(cnt == 0) {
					scr = new int[cnt+1];
					System.out.print("Data : ");
					int data = scan.nextInt();
					
					
					scr[cnt] = data;
				}else {
					int temp[] = scr;
					scr = new int [cnt +1];
					
					for (int i = 0; i < cnt; i++) {
						scr[i] = temp[i];
					}
					System.out.print("Data : ");
					int data = scan.nextInt();
					
					
					scr[cnt] = data;
					temp = null;
				}
				cnt += 1;
			}
			
			else if(sel == 2) {
				if(cnt == 1) {
					System.out.print("Delete Idx : ");
					scr = null;
				}else { 
					System.out.print("Delete Idx : ");
					int dIdx = scan.nextInt();
					
					int temp[] = scr;
					scr = new int [ cnt- 1];
					
					int j = 0;
					for (int i = 0; i < cnt; i++) {
						if(dIdx != i) {
							scr[j] = temp[i];
							j+=1;
						}
					}
					temp = null;
				}
				cnt -= 1;
			}
			else if(sel == 3) {
				
					System.out.print("Delete Data : ");
					int dData = scan.nextInt();
					
					int check = -1;
					for (int i = 0; i < scr.length; i++) {
						if(dData == scr[i]) {
							check = i;
						}
					}
					
					if(check == -1) {
						System.out.println("해당 값은 존재하지 않습니다.");
						continue;
					}

				if(cnt == 1) {
					scr= null;
				}
				else if(cnt > 1) {
					
					int temp []= scr;
					scr =  new int [cnt -1];
					
					int j = 0;
					for (int i = 0; i < cnt; i++) {
						if(dData != temp[i]) {
							scr[j] = temp[i];
							j+= 1;
						}
					}
					
					temp = null;
				}
				cnt -= 1;
			}
			else if(sel == 4) {
				
				System.out.print("Insert Idx : ");
				int iIdx = scan.nextInt();
				
				if(iIdx > cnt) {
					System.out.print("해당 인덱스에는 삽입할 수 없습니다.");
					continue;
				}
				
				System.out.print("Insert Data : ");
				int iData = scan.nextInt();
				
				 int temp [] = scr;
				 scr = new int[cnt + 1];
				 
				 int j = 0;
				 for (int i = 0; i < cnt+1; i++) {
					 if(iIdx != i) {
						 scr[i] = temp[j];
						 j+=1;
					 }
				}
				temp = null;
				scr[iIdx] = iData ;
				cnt+=1;
				
			}
			else if(sel == 0) {
				break;
			}


		}
	}

}
