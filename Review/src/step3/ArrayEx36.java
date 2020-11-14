package step3;

import java.util.Scanner;
/*
 * # 배열 컨트롤러[2단계] : 벡터(Vector)
 * 1. 추가
 * . 값을 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 값 삭제
 * 3. 삭제(값)
 * . 값을 입력받아 삭제
 * . 없는 값 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 값을 입력받아 삽입
 */
	

public class ArrayEx36 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] score = null;
		int cnt= 0;
		
		while(true) {
			
			for (int i = 0; i < cnt; i++) {
				System.out.print(score[i] + " ");
			}System.out.println();
			
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
					 score = new int[cnt+1];
				 }else {
					
					 int temp[] = score;
					 score = new int[cnt+1];
					 
					 for (int i = 0; i < cnt; i++) {
						score[i] = temp[i];
					}
					 
				 }
				 System.out.print("Data : ");
				 int data = scan.nextInt();
				 
				 score[cnt] = data;
				 cnt += 1;
			}
			else if(sel == 2) {
				System.out.print("Idx : ");
				int delIdx = scan.nextInt();
				
				if(delIdx < 0 || delIdx > cnt-1) {
					System.out.println("해당 위치는 삭제할 수 없습니다.");
					continue;
				}
				
				if(cnt == 1) {
					score = null;
				}else if(cnt > 1) {
					int temp[] = score;
					score = new int [cnt -1 ];
					
					for (int i = 0; i < delIdx; i++) {
						score[i] = temp[i];
					}
					for (int i = delIdx; i < cnt-1; i++) {
						score[i] = temp[i+1];
					}
					temp = null;
					
				}
				cnt -= 1;
			}
			else if(sel == 3) {
				System.out.print("Delete Data : ");
				int delData = scan.nextInt();
				
				int check = -1;
				for (int i = 0; i < cnt; i++) {
					if(delData == score[i]) {
						check = i;
					}
				}
				if(check == -1) {
					System.out.println("해당 데이터를 찾을수 없습니다.");
					continue;
				}
				
				int temp[] = score;
				score = new int[cnt-1];
				
				int j= 0;
				for (int i = 0; i < cnt; i++) {
					if(i != check) {
						score[j] = temp[i];
						j+=1;
					}
					
				}
				
				temp = null;
				cnt -= 1;
				
			}
			else if(sel == 4) {
				System.out.print("Idx : ");
				int idx = scan.nextInt();
				
				if(idx > cnt || idx < 0 ) {
					System.out.println("해당 위치에는 삽입할 수 없습니다.");
					continue;
				}
				
				System.out.print("Data : ");
				int data = scan.nextInt();
				
				int temp[] = score;
				score = new int[cnt+1];
				
				int j = 0;
				for (int i = 0; i < cnt+1; i++) {
					if(i != idx) {
						score[i] = temp[j];
						j +=1;
					}
				}
				temp = null;
				score[idx] =data;
				cnt +=1;
				
			}
			else if(sel == 0) {
				break;
			}
		}


	}

}
