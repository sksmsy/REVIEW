package step4_19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Ex02_sokoban {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		String fileName = "sokoban.txt";
		
		final int SIZE = 9;
		final int PLAYER = 3;
		final int WALL = 5;
		final int BALL = 9;
		final int GOAL = 7;
		
		int pX = 0, pY =0;
		
		int game[][] = new int[SIZE][SIZE];
		
		
		while(true) {
			
			System.out.println("[1] 소코반 메이커");
			System.out.println("[2] 시작");
			System.out.println("[0] 종료");
		
			int sel = scan.nextInt();
			
			
			if(sel == 1) {
				
				
				game[pY][pX] = PLAYER;
				
				while(true) {
					
					// game[pY][pX] = PLAYER; // [pY][pX] : 3 -> [5] -> 3
					
					
					for (int i = 0; i < SIZE; i++) {
						for (int j = 0; j < SIZE; j++) {
							if(game[i][j] == 0) {
								System.out.print("0\t");
							}else if(game[i][j] == PLAYER) {
								System.out.print("옷\t");
							}else if(game[i][j] == WALL) {
								System.out.print("벽\t");
							}else if(game[i][j] == GOAL) {
								System.out.print("골\t");
							}else if(game[i][j] == BALL) {
								System.out.print("공\t");
							}
						}
						System.out.println("\n");
					}
					
					
					System.out.println("[이동] [8]상 [2]하 [4]좌 [6]우");
					System.out.println("[실행] [5]벽 [7]골 [9]공");
					System.out.println("[종료] [0]");
					
					int mv = scan.nextInt();
				
				
					
					//이동
					if(mv == 8 || mv == 2 || mv == 4 || mv == 6) {
						int yy = pY;
						int xx = pX;

						if(mv == 8) {
							yy -= 1;
						}else if(mv == 2){
							yy += 1;							
						}else if(mv == 4) {
							xx -= 1;
						}else if(mv == 6) {
							xx += 1;
							
						}
						
						if(yy >= SIZE || yy < 0 )continue;
						if(xx >= SIZE || xx < 0 ) continue;
						
						// 기존 좌표에 아이템이 설치되지 않은 경우에만 리셋
						if(game[pY][pX] == PLAYER) {
							game[pY][pX] = 0;
						}
						pY = yy;
						pX = xx;
						
						game[pY][pX] = PLAYER;
					}
					
					//설치
					else if(mv == 5 || mv == 7 || mv == 9) {

						if(mv == 5) {
							game[pY][pX] = WALL; // [pY][pX] : 3 -> 5
						}else if(mv == 7) {
							game[pY][pX] = GOAL;
						}else if(mv == 9) {
							game[pY][pX] = BALL;
						}
					}
					
					
					
					//저장,종료
					else if(mv == 0) {
						FileWriter fw = null;
						String data = "";
						
						for(int i = 0; i < game.length; i++) {
							for (int j = 0; j < game.length; j++) {
								data += game[i][j] + "\t";
							}
							data += "\n";
						}
						
						try {
							fw = new FileWriter(fileName);
							fw.write(data);
							fw.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
			
						break;
					}
				}
			}
				
				
			
			else if(sel == 2) {
				
				//로드
				File file = new File(fileName);
				
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					
					String data = "";
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while(true) {
							String line =br.readLine();
							if(line == null) {
								break;
							}
							data += line;
							data += "\n";
						}
						data = data.substring(0, data.length()-1);
						
						String temp[] = data.split("\n");
						
						for (int i = 0; i < temp.length; i++) {
							String info[] = temp[i].split("\t");
							
							for (int j = 0; j < SIZE; j++) {
								game[i][j] = Integer.parseInt(info[j]);
							}
							
						}
						

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				
				
				
				//시작
				int bY = 0 , bX = 0;
				int gY = 0,  gX = 0;
				while(true) {
					for (int i = 0; i < SIZE; i++) {
						for (int j = 0; j < SIZE; j++) {
							if(game[i][j] == 0) {
								System.out.print("0\t");
							}else if(game[i][j] == PLAYER) {
								pY = i;
								pX = j;
								System.out.print("옷\t");
							}else if(game[i][j] == WALL) {
								System.out.print("벽\t");
							}else if(game[i][j] == GOAL) {
								gY = i;
								gX = j;
								System.out.print("골\t");
							}else if(game[i][j] == BALL) {
								bY = i; bX = j;
								System.out.print("공\t");
							}
						}
						System.out.println("\n");
					}
					
					if(bY == gY && bX == gX) {
						System.out.println ("끝~");
						break;
					}
					
					System.out.println("[이동] [8]상 [2]하 [4]좌 [6]우");
					int mv2 = scan.nextInt();
					
					//이동(시작)
					if(mv2 == 8 || mv2 == 2 || mv2 == 4 || mv2 == 6) {
						int yy = pY;
						int xx = pX;

						if(mv2 == 8) {
							yy -= 1;
						}else if(mv2 == 2){
							yy += 1;							
						}else if(mv2 == 4) {
							xx -= 1;
						}else if(mv2 == 6) {
							xx += 1;
							
						}
						
						if(yy >= SIZE || yy < 0 )continue;
						if(xx >= SIZE || xx < 0 ) continue;
						if(game[yy][xx] == WALL && game[yy][xx] == GOAL)continue;
						
						
						//공
						if(game[yy][xx] == BALL) {
							int xxx = bX;
							int yyy = bY;
							
							if(mv2 == 8) {
								yyy -= 1;
							}else if(mv2 == 2){
								yyy += 1;							
							}else if(mv2 == 4) {
								xxx -= 1;
							}else if(mv2 == 6) {
								xxx += 1;
								
							}
							if(yyy >= SIZE || yyy < 0 )continue;
							if(xxx >= SIZE || xxx < 0 ) continue;
							if(game[yyy][xxx] == WALL)continue;
							
							game[bY][bX] = 0;
							
							bY = yyy;
							bX = xxx;
							
							game[bY][bX] = BALL;

						
						}
						game[pY][pX] = 0;
						
						pY = yy;
						pX = xx;
						
						game[pY][pX] = PLAYER;
					}

				}
			}
			else if(sel == 0) {
				break;
			}
			
		}
		
	}

}
