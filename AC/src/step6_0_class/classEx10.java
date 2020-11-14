package step6_0_class;

import java.util.Scanner;

class Ex10{
	String arr[][] = new String[3][3];
	
	int turn = 0;
	int win = 0;
}

public class classEx10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		Ex10 e = new Ex10();

		for (int i = 0; i < e.arr.length; i++) {
			for (int j = 0; j < e.arr[i].length; j++) {
				e.arr[i][j] = "[ ]";
			}
		}
		
		while(true) {
			
			for (int i = 0; i < e.arr.length; i++) {
				for (int j = 0; j < e.arr[i].length; j++) {
					System.out.print(e.arr[i][j]);
				}
				System.out.println();
			}
			
			if(e.win == 1) {
				System.out.println("P1 승");
				break;
			}else if(e.win == 2) {
				System.out.println("P2 승");
				break;
			}
			
			
			
			if(e.turn % 2 == 0) {
				System.out.print("[P1]입력(X) : ");
				int x = sc.nextInt();
				System.out.print("[P1]입력(Y) : ");
				int y = sc.nextInt();
				
				if(x < 0 || x > 2) continue;
				if(y < 0 || y > 2) continue;
				
				if(e.arr[y][x].equals("[X]")) {
					continue;
				}
				
				e.arr[y][x] = "[O]";
				e.turn ++;
			}
					
			else if(e.turn % 2 == 1) {
				System.out.print("[P2]입력(X) : ");
				int x = sc.nextInt();
				System.out.print("[P2]입력(Y) : ");
				int y = sc.nextInt();
				
				
				if(x < 0 || x > 2) continue;
				if(y < 0 || y > 2) continue;
				
				if(e.arr[y][x].equals("[O]")) {
					continue;
				}
				
				e.arr[y][x] = "[X]";
				e.turn ++;
			}
		
			
			//검사
			
			for (int i = 0; i < e.arr.length; i++) {
				if(e.arr[i][0].equals("[O]") && e.arr[i][1].equals("[O]") && e.arr[i][2].equals("[O]")) {
					e.win = 1;
				}
				else if(e.arr[i][0].equals("[X]") && e.arr[i][1].equals("[X]") && e.arr[i][2].equals("[X]")) {
					e.win = 2;
				}
				
			}
			
			
			for (int i = 0; i < e.arr.length; i++) {
				if(e.arr[0][i].equals("[0]") &&e.arr[1][i].equals("[0]") && e.arr[2][i].equals("[0]")) {
					e.win = 1;
				}
				else if(e.arr[0][i].equals("[X]") && e.arr[1][i].equals("[X]") && e.arr[2][i].equals("[X]")) {
					e.win = 2;
				}
			}
			
				
			if(e.arr[0][0].equals("[O]") && e.arr[1][1].equals("[O]") && e.arr[2][2].equals("[O]")) {
				e.win = 1;
			}
			else if(e.arr[0][0].equals("[X]") && e.arr[1][1].equals("[X]") && e.arr[2][2].equals("[X]")) {
				e.win = 2;
			}
			
			if(e.arr[2][0].equals("[O]") && e.arr[1][1].equals("[O]") && e.arr[0][2].equals("[O]")) {
				e.win = 1;
			}
			else if(e.arr[2][0].equals("[X]") && e.arr[1][1].equals("[X]") && e.arr[0][2].equals("[X]")) {
				e.win = 2;
			}
			
			
			
		}
		
		
		
	}

}
