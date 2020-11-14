package step6_2_methodEx;

import java.util.Scanner;

class Ttt{
	
	Scanner sc = new Scanner(System.in);
	
	String game[][] = new String[3][3];
	
	int turn = 0;
	int win = 0;
	
	void set() {
		
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length; j++) {
				game[i][j] = " ";
			}
		}
	}
	
	void show() {
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length; j++) {
				if(game[i][j].equals(" ")) {
					System.out.print("[ ]");
				}else {
					System.out.print(game[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	void sel() {
		
		if(turn % 2 == 0) {
			System.out.print("[p1] Y :");
			int y = sc.nextInt();
			System.out.print("[p1] X :");
			int x = sc.nextInt(); 
			
			if(game[y][x].equals(" ")) {
				game[y][x] = "[O]";
				turn++;
			}
			
			
		}else if(turn % 2 == 1) {
			System.out.print("[p2] Y :");
			int y = sc.nextInt();
			System.out.print("[p2] X :");
			int x = sc.nextInt();

			if(game[y][x].equals(" ")) {
				game[y][x] = "[X]";
				turn++;
			}
		}
	}
	
	
	void check() {
		
		//
		for (int i = 0; i < game.length; i++) {
			if(game[i][0].equals("[O]") && game[i][1].equals("[O]") 
					&& game[i][2].equals("[O]")) {
				win =1;
			}
			else if(game[i][0].equals("[X]") && game[i][1].equals("[X]") 
					&& game[i][2].equals("[X]")) {
				win =2;
			}
		}
		for (int i = 0; i < game.length; i++) {
			if(game[0][i].equals("[O]") && game[1][i].equals("[O]") 
					&& game[2][i].equals("[O]")) {
				win =1;
			}
			else if(game[0][i].equals("[X]") && game[1][i].equals("[X]") 
					&& game[2][i].equals("[X]")) {
				win =2;
			}
		}
		
		if(game[0][0].equals("[O]") && game[1][1].equals("[O]") 
				&& game[2][2].equals("[O]")) {
			win = 1;
		}else if(game[0][0].equals("[X]") && game[1][1].equals("[X]") 
				&& game[2][2].equals("[X]")) {
			win = 2;
		}
		
		if(game[2][0].equals("[O]") && game[1][1].equals("[O]") 
				&& game[0][2].equals("[O]")) {
			win = 1;
		}else if(game[2][0].equals("[X]") && game[1][1].equals("[X]") 
				&& game[0][2].equals("[X]")) {
			win = 2;
		}
		
	}
	
	
	void run () {
		
		set();
		while(true) {
			
			show();
			
			if(win == 1) {
				System.out.println("[p1]win");
				break;
			}
			else if(win == 2) {
				System.out.println("[p2]win");
				break;
			}
			sel();
			check();
			
		}
	}
	
}

public class Ex15 {

	public static void main(String[] args) {

		Ttt t = new Ttt();
		
		t.run();
		
	}

}
