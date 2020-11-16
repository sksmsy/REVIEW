package step6_test;

import java.util.Scanner;

//#틱택토 

class TicTacToe{
	Scanner sc = new Scanner(System.in);
	
	String [][] game = new String[3][3];
	
	int turn = 0;
	int win = 0;
	
	void setGame() {
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length; j++) {
				game[i][j] =" ";
			}
		}
	}
	
	void showGame() {
		
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length; j++) {
				System.out.print("["+game[i][j]+"]");
			}
			System.out.println();
		}
		System.out.println("============");
	}
	
	
	void choiceIdx() {
		if(turn % 2 == 0) {
			System.out.print("[1p]x:");
			int x = sc.nextInt();
			System.out.print("[1p]y:");
			int y = sc.nextInt();
			
			if(game[y][x] .equals(" ")) {
				game[y][x] = "O";
				turn += 1;
			}
		}
		else if(turn % 2 == 1) {
			System.out.print("[2p]x:");
			int x = sc.nextInt();
			System.out.print("[2p]y:");
			int y = sc.nextInt();
			
			if(game[y][x] .equals(" ")) {
				game[y][x] = "X";
				turn += 1;
			}
		}
	}

	void widthCheck() {
		for (int i = 0; i < game.length; i++) {
			if(game[i][0].equals("O") && game[i][1].equals("O") && game[i][2].equals("O")) {
				win = 1;
			}
			else if(game[i][0].equals("X") && game[i][1].equals("X") && game[i][2].equals("X")) {
				win = 2;
			}
		}
	}
	
	void heightCheck() {
		for (int i = 0; i < game.length; i++) {
			if(game[0][i].equals("O") && game[1][i].equals("O") && game[2][i].equals("O")) {
				win = 1;
			}
			else if(game[0][i].equals("X") && game[1][i].equals("X") && game[2][i].equals("X")) {
				win = 2;
			}
		}
	}
	
	void crossCheck() {
		if(game[0][0].equals("O") && game[1][1].equals("O") && game[2][2].equals("O")) {
			win = 1;
		}
		if(game[2][0].equals("O") && game[1][1].equals("O") && game[0][2].equals("O")) {
			win = 1;
		}
		if(game[0][0].equals("X") && game[1][1].equals("X") && game[2][2].equals("X")) {
			win = 2;
		}
		if(game[2][0].equals("X") && game[1][1].equals("X") && game[0][2].equals("X")) {
			win = 2;
		}
	}
	
	
	void run() {
		
		setGame();
		
		while(true) {
			
			showGame();
			
			if(win == 1) {
				System.out.println("1p win");
				break;
			}
			else if(win == 2) {
				System.out.println("2p win");
				break;
			}
		
			choiceIdx();
			
			widthCheck();
			heightCheck();
			crossCheck();
		}
	}
	
}

public class test6 {

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		
		ttt.run();
	}

}
