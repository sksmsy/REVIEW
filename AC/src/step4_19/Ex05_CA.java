package step4_19;

import java.util.Random;
import java.util.Scanner;

public class Ex05_CA {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 7;
		final int PLAYER =  2;
		final int BOMB = 9;
		final int WALL = 8;
		final int ITEM = 6;
		
		boolean die = false;
		
		int bombMax = 3;
		int bCnt = 3;
		int wallCnt = 20;
		int itemCnt = 0;
		int pY = 0, pX = 0;
		
		int b [][] = new int[bombMax][2];
		int map [][] = new int[SIZE][SIZE];
		
		
		//벽 생성
		int k = 0;
		while(k<wallCnt) {
			int wY = ran.nextInt(SIZE);
			int wX = ran.nextInt(SIZE);
			
			if(map[wY][wX] == 0) {
				map[wY][wX] = WALL;
				k++;
			}
		}
		
		//플레이어 배치
		while(true) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				pY = rY; pX = rX;
				map[pY][pX] = PLAYER;
				break;
			}
		}
				
		//시작폭탄배치
		k = 0;
		while(k<bCnt) {
			int bY = ran.nextInt(SIZE);
			int bX = ran.nextInt(SIZE);
			
			if(map[bY][bX] == 0) {
				map[bY][bX] = BOMB;
				
				b[k][0] = bY;
				b[k][1] = bX;
				k++;
			}
		}
		
		
		
		//화면
		while(true) {
			
			System.out.println("설치가능 폭탄 : " + bombMax);
			System.out.println("설치된 폭탄 : " + bCnt);
			System.out.println("남은 벽 : " + wallCnt);
			System.out.println("획득한 아이템 : " + itemCnt);
			System.out.println("-----------------------------------");
			for (int i = 0; i < bCnt; i++) {
				System.out.println("["+(i+1)+"]"+b[i][0] + " : " + b[i][1]);
			}
			System.out.println("-----------------------------------");
			
			//map
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					
					if(map[i][j] == PLAYER) {
						System.out.print("옷\t");
					}else if(map[i][j] == BOMB) {
						System.out.print("●\t");
					}else if(map[i][j] == WALL) {
						System.out.print("벽\t");
					}else if(map[i][j] == ITEM) {
						System.out.print("★\t");
					}else {
						System.out.print("0\t");
					}
				}
				System.out.println("\n");
			}
			
			if(die == true) {
				System.out.println("플레이어 사망");
				break;
			}
			
			System.out.println("[5]상 [2]하 [1]좌 [3]우");
			System.out.println("[7]폭탄설치 [8]폭파");
			System.out.println("입력 : ");
			int mv = scan.nextInt();
			
			//이동 및 행동
			if(mv == 5 || mv == 2 || mv == 1 || mv == 3) {
				
				int yy = pY; int xx = pX;
				
				if(mv == 5) yy--;
				else if(mv == 2) yy++;
				else if(mv == 1) xx--;
				else if(mv == 3) xx++;
				
				
				if(xx >= SIZE || xx<0)continue;
				if(yy >= SIZE || yy<0)continue;
				if(map[yy][xx] == WALL || map[yy][xx] == BOMB) continue;
				
				//아이템 획득
				if(map[yy][xx] == ITEM) {
					
					int temp[][] = b;
					b = new int [bombMax+1][2];
					
					for (int i = 0; i < bCnt; i++) {
						b[i] = temp[i];
					}
					temp = null;
					
					bombMax ++;
					itemCnt ++;
				}
				
				if(map[pY][pX] == PLAYER || map[pY][pX] == ITEM) {
					map[pY][pX] = 0;
				}
				
				pY = yy; pX = xx;
				map[pY][pX] = PLAYER;
				
			}
			else if(mv == 7 || mv == 8) {
				
				//설치
				if(mv == 7) {
					
					if(bCnt == bombMax) {
						System.out.println("더이상 설치할 수 없습니다.");
						continue;
					}
					
			
					b[bCnt][0] = pY;
					b[bCnt][1] = pX;
					
					map[pY][pX] = BOMB;
					bCnt ++;
				}
				
				//폭파
				else if(mv == 8) {
					
					if(bCnt == 0) {
						continue;
					}
					
					
					int bY = b[0][0];
					int bX = b[0][1];
					
				
					
					for (int i = -1; i <= 1; i++) {
						if(bY+i < SIZE && bY+i >= 0) {
							
							if(map[bY + i][bX] == WALL) {
								if(ran.nextInt(2) == 0) {
									map[bY+i][bX] = ITEM;
								}else {
									map[bY+i][bX] = 0;
								}
								wallCnt --;
							}
							
							if(map[bY + i][bX] == PLAYER) {
								die = true;
							}
						}
			
						if(bX+i < SIZE && bX+i >= 0) {
							
							if(map[bY][bX + i] == WALL) {	
								
								if(ran.nextInt(2) == 0) {
									map[bY][bX+i] = ITEM;
								}else {
									map[bY][bX+i] = 0;
								}
								wallCnt --;
							}
							
							if(map[bY][bX + i] == PLAYER) {
								die = true;
							}
							
						}
						
					}
					map[bY][bX] = 0;
					for (int i = 0; i < bCnt-1; i++) {
						b[i] = b[i+1];
					}
					bCnt --;
					
				}
				
			}
			
		}
		
	}

}
