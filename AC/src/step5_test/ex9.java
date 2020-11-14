package step5_test;

import java.util.Scanner;

public class ex9 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
        String fileName = "board.txt";

		String[][] b = null;
		int cnt = 0;				// 전체 게시글 수
		int pageSize = 3;			// 한 페이지에 보여줄 게시글 수
		int pageNum = 1;			// 현재 페이지 번호
		int pageCnt = 0;			// 전체 페이지 개수
		int sta = 0;			// 현재 페이지의 게시글 시작 번호
		int end = 0;				// 현재 페이지의 게시글 마지막 번호
		
		while(true) {
			
			pageCnt = cnt / pageSize;
			if(cnt % pageSize >= 1) {
				pageCnt++;
			}
			
			System.out.println("전체 글 : " + cnt);
			System.out.println("페이지 : "+ pageNum + "/" + pageCnt);
			
			System.out.println("------------------------------");
			if(cnt == 0) {
				
				System.out.println("게시글 없음");
			}else {
				
				for (int i = sta; i < pageSize+end; i++) {
					if(i < cnt) {
						System.out.println("["+(i+1)+"]" + b[i][0]);
					}
				}
				
				
			}
			
			System.out.println("------------------------------");
			
	
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");

			int choice = scan.nextInt();
			
			if(choice == 1) {
				if(pageNum > 1) {
					sta -= pageSize;
					end -= pageSize;
					pageNum--;					
				}
			}
			else if(choice == 2) {
				if(pageCnt > pageNum) {
					sta += pageSize;
					end += pageSize;
					pageNum ++;
				}
			}
			else if(choice == 3) {
				if(cnt == 0) {
					b = new String[cnt+1][2];
				}else {
					String temp[][] = b;
					b = new String [cnt+1][2];
					
					for (int i = 0; i < temp.length; i++) {
						b[i] = temp[i];
					}					
				}
				
				System.out.print("제목 : ");
				String title = scan.next();
				
				System.out.print("내용 : ");
				String contents = scan.next();
				
				b[cnt][0] = title;
				b[cnt][1] = contents;
				
				cnt ++;
				
				
			}
			else if(choice == 4) {
				
				System.out.print("게시글 번호 : ");
				int del = scan.nextInt();

				if(cnt == 1 ) {
					
					if(del < 0 || del > cnt) {
						continue;
					}
					
					b = null;
				} else {
					
					String temp[][] = b;
					b = new String[cnt-1][2];
					
					
					int j = 0;
					for (int i = 0; i < temp.length; i++) {
						if(i != del-1) {
							b[j] = temp[i];
							j++;
						}
					}
					cnt --;
					
				}
			}
			else if(choice == 5) {
				System.out.print("게시글 번호 : ");
				int num = scan.nextInt();
				
				System.out.println(b[num-1][1]+"\n");
			}
		}
	}

}
//1630
//1705