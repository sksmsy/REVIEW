package step7_test;

import java.util.Scanner;

class Tic{
	int [] line = new int[3];
	
	void print_line() {
		for (int i = 0; i < line.length; i++) {
			if(line[i] == 1) {
				System.out.print("[O]");
			}else if(line[i] == 2) {
				System.out.print("[X]");
			}else {
				System.out.print("[ ]");
			}
		}
		System.out.println();
	}
	
}

public class test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Tic [] arr = new Tic[3];
		
		int win = 0 ;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Tic();
		}
		
		boolean  turn = true;
		
		while(true) {

			for (int i = 0; i < arr.length; i++) {
				arr[i].print_line();
			}
			
			if(win == 1) {
				System.out.println("[p1]win");
				break;
			}else if(win == 2){
				System.out.println("[p2]win");
				break;
			}
			
			System.out.print(">>>");
			int y = sc.nextInt();
			System.out.print(">>>");
			int x = sc.nextInt();
			
			if(turn == true) {
				if(arr[y].line[x] == 0) {
					arr[y].line[x] = 1;
					turn = false;
				}
			}
			else if(turn == false){
				if(arr[y].line[x] == 0) {
					arr[y].line[x] = 2;
					turn = true;
				}
			}
			

			//check
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].line[0] == 1 && arr[i].line[1] == 1 && arr[i].line[2] == 1) {
					win = 1;
				}
				else if(arr[i].line[0] == 2 && arr[i].line[1] == 2 && arr[i].line[2] == 2) {
					win = 2;
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[0].line[i] == 1 && arr[1].line[i] == 1 && arr[2].line[i] == 1) {
					win = 1;
				}
				else if(arr[0].line[i] == 2 && arr[1].line[i] == 2 && arr[2].line[i] == 2) {
					win = 2;
				}
			}
			
			if(arr[0].line[0] == 1 && arr[1].line[1] == 1 && arr[2].line[2] == 1) {
				win = 1;
			}else if(arr[0].line[0] == 2 && arr[1].line[1] == 2 && arr[2].line[2] == 2) {
				win = 2;
			} 
			
			if(arr[1].line[1] == 1 && arr[2].line[0] == 1 && arr[0].line[2] == 1) {
				win = 1;
			}
			else if(arr[1].line[1] == 2 && arr[2].line[0] == 2 && arr[0].line[2] == 2) {
				win = 2;
			}
			
			
			
		}
		
	}

}
//1645
//1655