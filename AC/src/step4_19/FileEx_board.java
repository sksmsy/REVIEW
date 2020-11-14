package step4_19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileEx_board {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
        String fileName = "board.txt";

		String[][] board = null;
		int cnt = 0;				// 전체 게시글 수
		int pageSize = 5;			// 한 페이지에 보여줄 게시글 수
		int curPageNum = 1;			// 현재 페이지 번호
		
		// pageCnt 활용 -> 디벨롭
		int pageCnt = 0;			// 전체 페이지 개수
		//int startRow = 0;			// 현재 페이지의 게시글 시작 번호
		//int endRow = 0;				// 현재 페이지의 게시글 마지막 번호
		
		
		//final int SIZE = 5;
		int viewPage = 0; // startIdx, endIdx
						  // 5       , 9
		int lastPage = 5;   // board size / SIZE (board size % SIZE > 0 => lastPage + 1)
		
		File file = new File(fileName);
		
		if(file.exists()) {
			FileReader fr = null;
			BufferedReader br = null;

			String data ="";
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
				
				board = new String[cnt][2];
				
				for (int i = 0; i < cnt; i++) {
					String temp2[] = temp[i].split("/");
					
					board[i][0] = temp2[0];
					board[i][1] = temp2[1];
				}
				
				fr.close();
				br.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		
		while(true) {
			pageCnt = cnt / pageSize;
			if(cnt % pageCnt > 0 ) {
				pageCnt += 1;
			}
			System.out.println("게시글 수 : "+cnt );
			System.out.println("현재 페이지 : "+curPageNum);
			System.out.println("------------------------");
			if(cnt == 0) {
				System.out.println("게시글 없음");
			}else {
				
				for (int i = 0; i < board.length ; i++) {
					if( i >= viewPage && i < lastPage) {
					System.out.println("["+(i+1)+"]" + board[i][0]);
					}
				}
				
			}
			
			System.out.println("------------------------\n");
			
			
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");

			int choice = scan.nextInt();
			
			if(choice == 1) {
				if(curPageNum > 1) {
					curPageNum --;
					viewPage -= 5;
					lastPage -= 5;
					
				}
			}
			
			
			else if(choice == 2) {
				if(curPageNum >= pageCnt) continue;
				curPageNum ++;
				viewPage +=5;
				lastPage +=5;
			
				
			}
			
			else if(choice == 3) {
				
				if(board == null) {
			
					board = new String[cnt][2];
				}
				
				
				String temp[][] = board;
				board = new String[cnt+1][2];	
				
				System.out.print("제목 : ");
				String title = scan.next();
				
				System.out.print("내용 : ");
				String content = scan.next();
				
				for (int i = 0; i < cnt; i++) {
					board[i][0] = temp[i][0];
					board[i][1] = temp[i][1];
				}
				temp = null;
				board[cnt][0] = title;
				board[cnt][1] = content;
				
				cnt ++;
				
				String data = "";
				
				for (int i = 0; i < cnt; i++) {
					data += board[i][0];
					data += "/";
					data += board[i][1];
					data += "\n";
				}
				data = data.substring(0, data.length()-1);
				
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				

			}
			
			else if(choice == 4) {
				System.out.println("삭제할 게시글 번호 : ");
				int delNum =scan.nextInt();
				
				if(cnt == 1 && delNum == 1) {
					board = null;
				}
				
				String temp[][] = board;
				board = new String[cnt-1][2];
			
				int j = 0;
				for (int i = 0; i < cnt; i++) {
					if(delNum-1 != i) {
						board[j][0] = temp[i][0];
						board[j][1] = temp[i][1];
						j++;
					}
				} 
				cnt --;
				
				String data = "";
				
				for (int i = 0; i < cnt; i++) {
					data += board[i][0];
					data += "/";
					data += board[i][1];
					data += "\n";
				}
				data = data.substring(0, data.length()-1);
				
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else if(choice == 5) {
				System.out.print("게시글 번호 : ");
				int num = scan.nextInt();
				
				System.out.println("--------"+board[num-1][0]+"--------");
				System.out.println(board[num-1][1]);
				System.out.println();
				
			}
			
			else if(choice == 6) {
				System.out.println("종료");
			}
			
			
			
			
		}
	}

}
