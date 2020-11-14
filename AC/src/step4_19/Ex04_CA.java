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

public class Ex04_CA {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		final int SIZE = 7;
		final int WALL = 3;
		final int PLAYER = 2;
		final int BOMB = 9;
		final int ITEM =4;
		
		
		boolean playerDead = false;
		int bombMaxCnt = 3; 	// 설치할 수 있는 최대 개수 (크기 고정 : 설치할 때만 컨트롤러에서 기억)
		int bCnt = bombMaxCnt; 	// 기본 보유폭탄 (아이템을 먹을 때 -> 증가(변화) : 주머니
		int wallCnt = 20;
		int itemCnt = 0;
		int pX = 0, pY = 0;
		
		
		// 폭탄을 순서대로 터트려야함
//		int bombX[] = new int [bombMaxCnt]; // 폭탄 컨트롤러 
//		int bombY[] = new int [bombMaxCnt]; // 폭탄 컨트롤러 
		
		// 폭탄 컨트롤러 : 폭탄을 순서대로 터트리기 위함
		int setCnt = 0;
		int bombCt[][] = new int[bombMaxCnt][2]; // [y][x]
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
				
				bombCt[k][0] = bY;
				bombCt[k][1] = bX;
				setCnt ++;
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
			System.out.println("[1]시작");
			System.out.println("[0]종료");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				while(true) {
					System.out.println("설치가능 폭탄 수 : " + bombMaxCnt);
					System.out.println("남아있는 폭탄 수 : " + bCnt);
					System.out.println("남아있는 벽\t : " + wallCnt);
					System.out.println("획득한 아이템 수 : " + itemCnt);
					System.out.println("-------------------------------");
					
					if(setCnt > 0) {
						for (int i = 0; i < setCnt; i++) {
							System.out.println("["+(i+1)+"]" +bombCt[i][0] + ":"+bombCt[i][1]);
							
						}
					}
					System.out.println("-------------------------------");
					
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
							if(bombMaxCnt > 0) {
						//		if(setCnt == bombMaxCnt) {
									map[pY][pX] = BOMB;
									
									// 폭탄 컨트롤러에 좌표기억
									
									bombCt[setCnt][0] = pY;
									bombCt[setCnt][1] = pX;
									setCnt ++;
									
									bCnt ++;
							//	}
							}
						}
						// 폭파
						else if(mv == 8) {
							if (bombMaxCnt > 0 && setCnt > 0) {
								// BombCt : {{0,0}{3,4}{5,6}}
								
								// 첫번째 터트릴 폭탄의 좌표를 기억
								int bY = bombCt[0][0]; // 0
								int bX = bombCt[0][1]; // 0
								
								// 폭탄 컨트롤러 수정
								for(int i=0; i<bombCt.length-1; i++) {
									bombCt[i][0] = bombCt[i+1][0];
									bombCt[i][1] = bombCt[i+1][1];
								}
								
								
								// 터트려!!! : bY와 bX를 검사
								// ㄴ 범위 : 십자방향 한 칸
								
								// . 주변에 있는 것 :
								// ㄴ 예외처리(맵사이즈)
								// ㄴ 벽 -> 부수고 -> (랜덤 아이템 생성)
								// ㄴ 사람 -> 게임오버
								
								
								
								
								// 동
//								map[bY][bX+1]
								if(bX != SIZE-1) {
									
									if(map[bY][bX+1] == WALL) {
										map[bY][bX+1] = 0;
										int r = ran.nextInt(9);
										
										if(r > 3) {
											map[bY][bX+1] = ITEM;
										}
									}
									else if(map[bY][bX+1] == PLAYER) {
										System.out.println("Game Over");
										break;
									}
								}
								// 서
//								map[bY][bX-1]
								if(bX != 0) {
								
									if(map[bY][bX-1] == WALL) {
										map[bY][bX-1]= 0;
										int r = ran.nextInt(9);
										
										if(r > 3) {
											map[bY][bX-1] = ITEM;
										}
									}
									else if(map[bY][bX-1] == PLAYER) {
										System.out.println("Game Over");
										break;
									}
								}
								// 남
//								map[bY+1][bX]
								if(bY != SIZE-1) {
								
									if(map[bY+1][bX] == WALL) {
										map[bY+1][bX] = 0;
										int r = ran.nextInt(9);
										
										if(r > 3) {
											map[bY+1][bX] = ITEM;
										}
									}
									else if(map[bY+1][bX] == PLAYER) {
										System.out.println("Game Over");
										break;
									}
								}
								// 북
//								map[bY-1][bX]		
								if(bY != 0) {
								
									if(map[bY-1][bX] == WALL) {
										map[bY-1][bX]=0;
										int r = ran.nextInt(9);
										
										if(r > 3) {
											map[bY-1][bX] = ITEM;
										}
									}
									else if(map[bY-1][bX] == PLAYER) {
										System.out.println("Game Over");
										break;
									}
								}

								map[bY][bX] = 0;
								
								bCnt --;
								setCnt --;
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
			else if(sel == 0 ) break;
		}
		
	}

}
