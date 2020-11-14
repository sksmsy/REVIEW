package step7_test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Game8{
	int game[][] = {
			{2,0,2,2},
			{0,0,0,2},
			{0,0,0,0},
			{0,2,0,0}
	};
	
	
	void print() {
		System.out.println("-------------------------");
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(game[i]));
		}
		System.out.println("-------------------------");
	}
	
	void randomNum() {
		Random ran = new Random();
		while(true) {
			int y = ran.nextInt(4);
			int x = ran.nextInt(4);
			if(game[y][x] == 0) {
				game[y][x] = 2;
				break;
			}
		}
	}
	boolean end() {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(game[i][j] != 0) {
					cnt ++;
				}
			}
		}
		if(cnt == 16) {
			return true;
		}
		else {
			return false;
		}
	}
	void move(int dir) {
		for (int i = 0; i < 4; i++) {
			if(dir == 1) {
				int check = 0;
				for (int j = 0; j < 4; j++) {
					if(game[i][j] != 0) {
						game[i][check] = game[i][j];
						if(check != j) {
							game[i][j] = 0;
						}
						check +=1;
					}
				}
			}
			if(dir == 2) {
				int check =3;
				int k = 3;
				for (int j = 0; j < 4; j++) {
					if(game[i][k] != 0) {
						game[i][check] = game[i][k];
						if(check != k) {
							game[i][k] = 0;
						}
						
						check -= 1;
					}
					k -= 1;
					
				}
			}
		}
	}
	
	void sum(int dir) {
		for (int i = 0; i < 4; i++) {
			if(dir == 1){
				for (int j = 0; j < 3; j++) {
					if(game[i][j] == game[i][j+1]) {
						game[i][j] += game[i][j+1];
						game[i][j+1] = 0;
						j += 1;
					}
				}
			}
			
			if(dir == 2) {
				int k = 3;
				for (int j = 0; j < 3; j++) {
					if(game[i][k] == game[i][k-1]) {
						game[i][k] += game[i][k-1];
						game[i][k-1]=0;
						k-=1;
						j+=1;
					}
				}
			}
		}
	}
	
	void play() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			randomNum();
			print();
			System.out.println("1)left 2)right 3)up 4)down");
			int dir = sc.nextInt();
			move(dir);
			sum(dir);
			move(dir);
			if(end()) {
				System.out.println("game over");
				break;
			}
		}
	}
}
public class test8 {

	public static void main(String[] args) {
		Game8 game = new Game8();
		
		game.play();
	}

}
