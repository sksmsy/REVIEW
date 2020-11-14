package step5_test;

import java.util.Random;
import java.util.Scanner;

public class ex8 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 7;
		final int WALL = 3;
		final int PLAYER = 2;
		final int BOMB = 9;
		final int ITEM = 4;

		int bombMaxCnt = 4;
		int bombCnt = bombMaxCnt;
		int wallCnt = 20;
		int pX = 0;
		int pY = 0;
		int b[][] = new int [bombMaxCnt][2];
		int[][] map = new int[SIZE][SIZE];
		boolean run = true;

		
		//벽설치
		int k = 0;
		while(k < wallCnt) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = WALL;
				k++;
			}
		}
		
		
		//캐릭터 배치
		while(true) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = PLAYER;
				pY = rY;
				pX = rX;
				break;
			}
		}
		
		
		//초기 폭탄
		k = 0;
		while(k < bombMaxCnt) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = BOMB;
				
				b[k][0] = rY;
				b[k][1] = rX;
				k++;
				
				
			}
		}
		

		while(true) {
		
			System.out.println("설치가능 폭탄 : " + bombMaxCnt);
			System.out.println("설치된 폭탄 : " + bombCnt);
			System.out.println("--------------------------------");
			if(bombCnt > 0) {
				for (int i = 0; i < b.length; i++) {
					System.out.println("["+(i+1)+"]"+b[i][0] + ":"+b[i][1]);
				}
			}else {
				System.out.println("설치된 폭탄 없음");
			}
			System.out.println("--------------------------------");
			
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if(map[i][j] == PLAYER) {
						System.out.print("옷\t");
					}else if(map[i][j] == BOMB) {
						System.out.print("폭\t");
					}else if(map[i][j] == WALL) {
						System.out.print("벽\t");
					}else if(map[i][j] == ITEM) {
						System.out.print("아\t");
					}else {
						System.out.print("0\t");
					}
				}
				System.out.println("\n");				
			}
			System.out.println();
			
			
			if(run == false) {
				System.out.println("DIE");
				break;
			}
			
			System.out.println("입력");
			int mv = scan.nextInt();
		
			
			
			if(mv == 4 | mv == 5 | mv == 6 | mv == 8) {
				
				int yy = pY;
				int xx = pX;
				
				if(mv == 8) yy--;
				else if(mv == 5) yy++;
				else if(mv == 4) xx--;
				else if(mv == 6) xx++;
				
				if(yy >= SIZE || yy < 0) continue;
				if(xx >= SIZE || xx < 0) continue;
				if(map[yy][xx] == BOMB || map[yy][xx] == WALL)continue;
				if(map[yy][xx] == ITEM) bombMaxCnt ++;
				
				if(map[pY][pX] == PLAYER) {
					map[pY][pX] = 0;
				}
				
				pY = yy;
				pX = xx;
				map[pY][pX] = PLAYER;
				
				
			}else if(mv == 7 || mv == 9) {
				
				if(mv == 7) {
					
					if(bombCnt < bombMaxCnt) {
						
						map[pY][pX] = BOMB;
						
						
						
						int temp[][] = b;
						b = new int[bombCnt+1][2];
						
						for (int i = 0; i < temp.length; i++) {
							b[i] = temp[i];
						}
						

						b[bombCnt][0] = pY;
						b[bombCnt][1] = pX;
						
						bombCnt++;
						
						
					}else {
						System.out.println("더이상 설치할 수 없습니다.");
					}
					
				}
				else if(mv == 9) {
					
					if(bombCnt > 0) {
						
						int bY = b[0][0];
						int bX = b[0][1];
						
						map[bY][bX] = 0;
							
						for (int i = -1; i <= 1; i++) {
							if(bY+i > 0  && bY+i < SIZE) {
								
								if(map[bY+i][bX]==WALL) {
									
									int r = ran.nextInt(2);
									if(r > 0) {
										map[bY+i][bX] = 0;									
									}else {
										map[bY+i][bX] = ITEM;																		
									}
								}else if(map[bY+i][bX]==PLAYER) {
									run = false;
								}
							}
						}
						for (int i = -1; i <= 1; i++) {
							if(bX+i > 0  && bX+i < SIZE) {
								if(map[bY][bX+i] == WALL) {
									
									int r = ran.nextInt(2);
									if(r > 0) {
										map[bY][bX+i] = 0;									
									}else {
										map[bY][bX+i] = ITEM;																		
									}
								}else if(map[bY][bX+i]==PLAYER) {
									run = false;
								}
							}
						}
			
						int temp[][] = b;
						b = new int[bombCnt-1][2];
						
						for (int i = 0; i < b.length; i++) {
							b[i] = temp[i+1];
						}
						temp = null;
						bombCnt--;
						
					}
					else {
						System.out.println("설치된 폭탄이 없습니다.");
					}
				}
			}
			
		}
		
		
	}
}
//1720
//1750

//1520
//1615