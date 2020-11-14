package step4_19;

import java.util.Random;
import java.util.Scanner;

public class Ex {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 10;
		
		int leng = 4;
		int snake[][] = new int[leng][2]; // 스네이크 좌표
		
		int map[][] = new int[SIZE][SIZE];
		
		int itemCnt = 0;
		
		// 스네이크 셋팅
		for(int i=0; i<leng; i++) {
			snake[i][1] = i+4;
		}
		
		boolean isRun = true;
		while(isRun) {
			
			// 스네이크 맵에 그리기
			for(int i=0; i<leng; i++) {
				map[snake[i][0]][snake[i][1]] = 1;
			}
			
			// 출력
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == 1) {
						System.out.print(" ■ ");
					} else if(map[i][j] == 2){
						System.out.print(" ● ");
					}else {
						System.out.print(" + ");
					}
				}
				System.out.println();
			}
			
			// 입력
			System.out.println("[4]좌 [6]우\n[8]상 [5]하");
			System.out.println("이동 : ");
			int sel = sc.nextInt();
			
			
			int xx = snake[0][1];
			int yy = snake[0][0];
			
			if(sel == 4 || sel == 6 || sel == 8 || sel == 5) {
				
				if(sel == 4) xx--;
				else if(sel == 6) xx++;
				else if(sel == 8) yy--;
				else if(sel == 5) yy++;
				
				
				if(yy >= SIZE || yy < 0) continue;
				if(xx >= SIZE || xx < 0) continue;
				
				if(map[yy][xx] == 1) {
					isRun = false;
					System.out.println("죽었습니다.");
				}
				
				//아이템 
				if(map[yy][xx] == 2) {
					leng ++;
					
					int temp[][] = snake;
					snake = new int [leng][2];
					
					for (int i = 0; i < temp.length; i++) {
						snake[i] = temp[i];
					}
					map[snake[leng-1][0]][snake[leng-1][1]] = 1;
				}
				
				map[snake[leng-1][0]][snake[leng-1][1]] = 0;
				for (int i = leng-1; i > 0; i--) {
					snake[i][0] = snake[i-1][0];
					snake[i][1] = snake[i-1][1];
				}
				
				snake[0][0] = yy;
				snake[0][1] = xx;
			}

			//	아이템 생성
			while(itemCnt != 4) {
				int rY = ran.nextInt(SIZE);
				int rX = ran.nextInt(SIZE);
				
				if(map[rY][rX] == 0) {
					map[rY][rX] = 2;
					itemCnt++;
					break;
				}
			}
			
		}

		
	}

}
