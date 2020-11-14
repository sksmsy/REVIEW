package step7;

import java.util.Scanner;

class Tic{
	int [] line = new int[3];
	
	void printLine() {
		for (int i = 0; i < line.length; i++) {
			if(line[i] == 0 ) {
				System.out.print("[ ]");
			}else if( line[i] == 1) {
				System.out.print("[O]");
			}else if(line[i] == 2) {
				System.out.print("[X]");
			}
		}
		System.out.println();
	}
	
}



public class Ex05 {
	public static void main(String[] args) {
		
		boolean run = true;
		Tic [] tict = new Tic[3];
		for (int i = 0; i < tict.length; i++) {
			tict[i] = new Tic();
		}
		Scanner sc = new Scanner(System.in);
		boolean turn = true;
		while(run) {
			for (int i = 0; i < tict.length; i++) {
				tict[i].printLine();
			}
			System.out.println();
			System.out.print("y >>");
			int y = sc.nextInt();
			System.out.print("X >>");
			int x = sc.nextInt();
			if(turn == true && tict[y].line[x] == 0) {
				turn = false;
				tict[y].line[x] = 1;
			}else if(turn == false && tict[y].line[x] == 0) {
				turn = true;
				tict[y].line[x] = 2;
			}
		}
		
		
	}
}
