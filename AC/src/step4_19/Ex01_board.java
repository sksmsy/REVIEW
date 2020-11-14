package step4_19;

import java.util.Scanner;

public class Ex01_board {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String fileName = "board3.txt";
		
		String board[][] = null;
		
		int cnt = 0;
		int pageSize = 5;
		int pageCnt = 0;
		int pageNum = 1;
		int sta = 0;
		int end = 0;
		
		
		
		
		
		while(true) {
			pageCnt = cnt / pageSize;
			if(cnt % pageSize > 0) {
				pageCnt += 1;
			}
			
			sta = (pageNum - 1) * pageSize;
			end = sta + pageSize;
			if(end > cnt) {
				end = cnt;
			}
			System.out.println("게시글 : " + cnt + "개");
			System.out.println("게시글 : " + pageCnt + "개");
			System.out.println("현재 페이지 : " + pageNum);
			
			for (int i = sta; i < end; i++) {
				System.out.println("[" +(i+1)+ "]" + board[i][0]);
			}
			System.out.println();
			
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가");
			System.out.println("[4]삭제");
			System.out.println("[5]내용보기");
			
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(pageNum == 1) continue;
				pageNum -= 1;
			}
			else if(sel == 2) {
				if(pageNum >= pageCnt) continue;
				pageNum +=1;
			}
			
			else if(sel == 3) {
				if(cnt == 0 ) {
					board = new String[cnt+1][2];
					
				}else {
					String temp[][] = board;
					board = new String [cnt+1][2];
					
					for (int i = 0; i < cnt; i++) {
						board[i][0] = temp[i][0];
						board[i][1] = temp[i][1];
					}
					temp = null;
				}
				System.out.println("제목 : ");
				board[cnt][0] = scan.next();
				System.out.println("내용 : ");
				board[cnt][1] = scan.next();
				
				cnt ++;
				
			}
			else if(sel == 4) {
				System.out.println("삭제할 게시물 번호 : ");
				int del = scan.nextInt();
				
				if(cnt == 1) {
					board = null;
				}else {
					String temp[][] = board;
					board = new String[cnt-1][2];
					
					
					int j =0;
					for (int i = 0; i < cnt; i++) {
						if(del-1 != i) {
							board[j][0] = temp[i][0];
							board[j][1] = temp[i][1];
							j++;
						}
					}
					temp = null;
				}
				cnt --;
			}
			else if(sel == 5) {
				
			}
			
		}
		
		
	}

}
