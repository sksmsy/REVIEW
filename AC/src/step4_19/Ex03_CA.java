package step4_19;

import java.util.Random;
import java.util.Scanner;

/*
 * # 크레이지 아케이드
 * 1. 맵의 크기는 7 x 7 이다. 0
 * 2. 상(1)하(2)좌(3)우(4)로 이동이 가능하며,
 *    폭탄설치(5), 폭파(6)로 설정한다. 0
 * 3. 벽(3), 플레이어(2), 폭탄(9), 아이템(4)로 설정한다.0
 * 4. 단, 폭탄이 설치된 순서대로 터져야 하며,
 *    폭파 시 십자가 형태로 터진다.
 * 5. 벽 파괴시 아이템이 랜덤하게 생성되어,
 *    아이템을 먹으면 설치할 수 있는 폭탄의 개수가 증가된다.
 */

public class Ex03_CA {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		final int SIZE = 7;
		final int WALL = 3;
		final int PLAYER = 2;
		final int BOMB = 9;
		final int ITEM =4;
		
		
		boolean playerDead = false;
		int bombMaxCnt = 3; // 기본 보유폭탄 (아이템을 먹을 때 -> 증가(변화)
		int bCnt = bombMaxCnt;
		int wallCnt = 20;
		int itemCnt = 0;
		int pX = 0, pY = 0;
		
		
		// 폭탄을 순서대로 터트려야함
//		int bombX[] = new int [bombMaxCnt]; // 폭탄 컨트롤러 
//		int bombY[] = new int [bombMaxCnt]; // 폭탄 컨트롤러 
		
		// 폭탄 컨트롤러 : 폭탄을 순서대로 터트리기 위함
		int bombCt[][] = new int[bombMaxCnt][bombMaxCnt]; // [y][x]
		int map [][] = new int [SIZE][SIZE];
		
		//벽
		int k = 1;
		while(k < wallCnt) {
			int wY = ran.nextInt(SIZE);
			int wX = ran.nextInt(SIZE);
			
			if(map[wY][wX] == 0) {
				map[wY][wX] = WALL;
				k ++;
			}
		}
		
		//폭탄
		k = 0;
		while(k < bombMaxCnt) {
			int bY = ran.nextInt(SIZE);
			int bX = ran.nextInt(SIZE);
			
			if(map[bY][bX] == 0) {
				map[bY][bX] = BOMB;
				k++;
			}
		}
		
		
		//플레이어
		while(true) {
			pX = ran.nextInt(SIZE);
			pY = ran.nextInt(SIZE);
			
			if(map[pY][pX] == 0) {		
				map[pY][pX] = PLAYER;
				break;
			}
		}

		
		// 시작
		while(true) {
			System.out.print("[1]시작");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				while(true) {
					System.out.println("설치가능 폭탄 수 : " + bombMaxCnt);
					System.out.println("남아있는 폭탄 수 : " + bCnt);
					System.out.println("남아있는 벽\t : " + wallCnt);
					System.out.println("획득한 아이템 수 : " + itemCnt);
					
					for (int i = 0; i < SIZE; i++) {
						for (int j = 0; j < SIZE; j++) {
							if(map[i][j] == 0) {
								System.out.print("0\t");
							}else if(map[i][j] == 2) {
								System.out.print("옷\t");
							}else if(map[i][j] == 3) {
								System.out.print("벽\t");
							}else if(map[i][j] == 4) {
								System.out.print("아\t");
							}else if(map[i][j] == 9) {
								System.out.print("●\t");
							}
						}
						System.out.println("\n");
					}
					
					System.out.println("[5]상 [2]하 [1]좌 [3]우");
					System.out.println("[7]설치 [8]폭파");
					int mv = scan.nextInt();
					
					//이동
					if(mv == 1 || mv == 2 || mv == 3 || mv == 5) {
						
						int xx = pX;
						int yy = pY;
						
						if(mv == 1) {
							xx--;
						}else if(mv == 2) {
							yy++;
						}else if(mv == 3) {
							xx++;
						}else if(mv == 5) {
							yy--;
						}
						
						if(SIZE <= xx || xx < 0) continue;
						if(SIZE <= yy || yy < 0) continue;
						if(map[yy][xx] == WALL || map[yy][xx] == BOMB) continue;
						if(map[yy][xx] == ITEM) {
							bombMaxCnt ++;
							itemCnt ++;
						}
						
						if(map[pY][pX] == PLAYER) {
							map[pY][pX] = 0;
						}
						pY = yy;
						pX = xx;
						map[pY][pX] = PLAYER;
					}
					
					//행동
					if(mv == 7 || mv == 8) {
						
						// 설치
						if(mv == 7) {
							if(bCnt != 0) {
								map[pY][pX] = BOMB;
								bCnt --;
							}
						}
						// 폭파
						else if(mv == 8) {
							if (bombMaxCnt > 0) {
								// BombCt : {{0,0}{3,4}{5,6}}
								
								// 첫번째 터트릴 폭탄의 좌표를 기억
								int bY = bombCt[0][0]; // 0
								int bX = bombCt[0][1]; // 0
								
								// 폭탄 컨트롤러 수정
								if(bombMaxCnt == 1) {
									bombCt = null;
								} else {
									// BombCt : {{3,4}{5,6}}
									int temp[][] = new int[bombMaxCnt -1][bombMaxCnt -1];
									for(int i=1; i<bombMaxCnt-1; i++) {
										temp[i][0] = bombCt[i+1][0];
										temp[i][1] = bombCt[i+1][1];
									}
									bombCt = temp;
									bombMaxCnt -= 1;
								}
								
								// 터트려!!!
								
								
								
								
							}
							
							
							
//							for (int i = 0; i <SIZE; i++) {
//								for (int j = 0; j <SIZE; j++) {
//									if(map[i][j] == BOMB) {
//									}
//								}	
//							}
						}
					}
					
					
				}
				
				
			}
		}
		
	}

}
